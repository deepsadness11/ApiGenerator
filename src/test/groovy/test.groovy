import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import global.Config
import global.ff
import groovy.json.JsonSlurper
import util.GPoetUtil

import javax.lang.model.element.Modifier

/**
 * Created by Administrator on 2017/2/15 0015.
 */
def map = ['a': [['b': ['c': 1, 'd': 2]], ['e': ['f': 3, 'g': 4]]], 'h': ['i': 5, 'g': 6], 'e': ['k': ['i': 7, 'm': 8], 'n': 9], 'o': 13.4]

//遍历子节点，子节点不是map的可以。如果是Object对象，就添加的classList里面，供给后面添加。如果不是，则创建新的节点，进行循环
//开始的时候innerBuilder为null
static
def generateResponse2(json, ClassName outSide, TypeSpec.Builder originBuilder, TypeSpec.Builder innerBuilder, TypeSpec.Builder nInnerBuilder) {
    //如果是map，就进行遍历
    if (json instanceof Map) {
        //只要是map。就必须创建对应的类了。

        //第二个循环开始变成内部类，也就是说，应该把第一个map放到外面
        json.forEach {
            k, v ->
                if (v instanceof Map) {
                    //如果是map，就递归进行
                    def inside = k.toString().concat('Bean').capitalize()
                    ClassName inner = outSide.nestedClass(inside)
                    innerBuilder = TypeSpec.classBuilder(inner).addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    originBuilder.addField(inner, k.toString(), Modifier.PUBLIC)
                    def newInnerBuilder
                    generateResponse2(v, inner, originBuilder, innerBuilder, newInnerBuilder)
                    innerBuilder = null
                } else if (v instanceof List) {
                    //如果是list{
                    ClassName items = outSide.nestedClass(k.toString().concat("Bean").capitalize());
                    ClassName list = ClassName.get("java.util", "List");
                    ClassName arrayList = ClassName.get("java.util", "ArrayList");
                    TypeName itemList = ParameterizedTypeName.get(list, items);
                    def f = new FieldSpec.Builder(itemList, k.toString()).addModifiers(Modifier.PUBLIC).build()

                    originBuilder.addField(f)

                    //创建一个itemsClass的内部类
                    innerBuilder = TypeSpec.classBuilder(items).addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    def inn
                    v.forEach {
                        a ->
                            generateResponse2(a, items, innerBuilder, inn, null)
//                            innerBuilder = null
                    }
                } else {
                    //k 就是方法的名称。 v 就是 object
                    def cn = ClassName.get(v.getClass())
                    if (nInnerBuilder != null) {
                        nInnerBuilder.addField(new FieldSpec.Builder(cn, k.toString()).addModifiers(Modifier.PUBLIC).build())
                    } else if (innerBuilder != null) {
                        innerBuilder.addField(new FieldSpec.Builder(cn, k.toString()).addModifiers(Modifier.PUBLIC).build())
                    } else {
                        originBuilder.addField(new FieldSpec.Builder(cn, k.toString()).addModifiers(Modifier.PUBLIC).build())
                    }
                }

        }
        if (nInnerBuilder != null) {
            innerBuilder.addType(nInnerBuilder.build())
            nInnerBuilder == null
        }
        if (innerBuilder != null) {
            originBuilder.addType(innerBuilder.build())
            innerBuilder == null
        }
    }
//        originBuilder.addType()
//        GPoetUtil.print2File(Config.FILE_PATH.RESPONSE, Config.PACKAGE_NAME.RESPONSE, originBuilder.build())
//    if (innerBuilder != null)
//        originBuilder.addType(innerBuilder.build())
}

def ClassName out = ClassName.get(Config.PACKAGE_NAME.RESPONSE, 'testP')
def originBuilder = TypeSpec.classBuilder(out).addModifiers(Modifier.PUBLIC)
def innerBuilder

def re = new JsonSlurper().parseText(ff.FF)

generateResponse2(re, out, originBuilder, null, null)
GPoetUtil.print2Out(Config.PACKAGE_NAME.RESPONSE, originBuilder.build())