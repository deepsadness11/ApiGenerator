package util

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import global.Config

import javax.lang.model.element.Modifier

/**
 * Created by Administrator on 2017/2/15 0015.
 */

//定义三个解析的方法。此时v是map
def parseMap(ClassName out, TypeSpec.Builder tb, k, v, isFirst) {
    //map 也需要生成一个对象。
    String fieldName = k.toString()
    //开始遍历。
    TypeSpec.Builder Tb
    TypeSpec mapTs
    if (isFirst) {
        mapTs = forMap(out, tb, k, v);
    } else {
        def d = out.simpleNames()
        if (d.last() == fieldName) {
            mapTs = forMap(out, tb, k, v);
        } else {
            //生成内部类的名称
            String clsName = k.toString().split('_').collect().join("").concat("Bean").capitalize()
            ClassName items = out.nestedClass(clsName);
            //将需要生成的内部类添加成成员变量
            def field = FieldSpec.builder(items, fieldName, Modifier.PUBLIC).build()
            tb.addField(field)

            //生成内部类的类
            Tb = createMapTb(clsName)
            mapTs = forMap(items, Tb, k, v);
            tb.addType(mapTs)
        }
    }

}
//解析list的时候，需要生成listFiled.此时v是type 是list
def parseList(ClassName out, TypeSpec.Builder tb, k, v) {

    String clsName = k.toString().split('_').collect().join("").concat("Bean").capitalize()
    String fieldName = k.toString()

    def f = createNestListField(out, clsName, fieldName)
    tb.addField(f)
    //这个f需要自己构建对象
    TypeSpec.Builder listItemTb = createListTb(clsName)
    //开始遍历。
    ClassName items = out.nestedClass(clsName);
    TypeSpec listTs = forMapList(items, listItemTb, clsName, v);
    //遍历结束时，需要输出一个
    tb.addType(listTs)
}

//解析Obj最容易.只要将对应的键值对放到field里面就可以
def static parseObject(TypeSpec.Builder tb, k, v) {

    def f = createFiled(k, v)
    tb.addField(f)
}

private static def createFiled(k, v) {
    ClassName c = ClassName.get(v.class)
    FieldSpec.builder(c, k.toString(), Modifier.PUBLIC).build()
}

private static def createField(ClassName outSide, String clsName, String filedName) {
    ClassName items = outSide.nestedClass(clsName);
    def listField = FieldSpec.builder(items, filedName, Modifier.PUBLIC).build()
}


private static def createListField(String clsName, String filedName) {
    ClassName item = ClassName.get(Config.PACKAGE_NAME.RESPONSE, clsName)
    ClassName list = ClassName.get("java.util", "List");
    TypeName itemList = ParameterizedTypeName.get(list, item);
    def listField = FieldSpec.builder(itemList, filedName, Modifier.PUBLIC).build()
}

private static createNestListField(ClassName outSide, String clsName, String filedName) {
    ClassName items = outSide.nestedClass(clsName);
    ClassName list = ClassName.get("java.util", "List");
    TypeName itemList = ParameterizedTypeName.get(list, items);
    def listField = FieldSpec.builder(itemList, filedName, Modifier.PUBLIC).build()
}


private static createMapTb(String clsName) {
    TypeSpec.classBuilder(clsName).addModifiers(Modifier.PUBLIC, Modifier.STATIC)
}

private static createListTb(String clsName) {
    TypeSpec.classBuilder(clsName).addModifiers(Modifier.PUBLIC, Modifier.STATIC)
}


private def forMapList(ClassName outClsName, TypeSpec.Builder builder, k, List v) {
    v.forEach {
        i ->
            startParse(outClsName, builder, k, i, false);
    }
    return builder.build()
}

private def forMap(ClassName outClsName, TypeSpec.Builder builder, k, Map v) {
    v.forEach {
        ek, ev ->
            startParse(outClsName, builder, ek, ev, false);
    }
    return builder.build()
}


def startParse(ClassName outClsName, TypeSpec.Builder builder, k, v, isFirst) {
    if (v instanceof Map) {
        parseMap(outClsName, builder, k, v, isFirst)
    } else if (v instanceof List) {
        //这个要怎么制定
        parseList(outClsName, builder, k, v)
    } else {
        parseObject(builder, k, v)
    }
}

//
//def responseName = 'reClass'
//
////生成className的方法
//ClassName out = ClassName.get(Config.PACKAGE_NAME.RESPONSE, responseName)
//def re = new JsonSlurper().parseText(ff.FF)
//TypeSpec.Builder outTb = TypeSpec.classBuilder(out).addModifiers(Modifier.PUBLIC)
//
//startParse(out, outTb, responseName, re, true)
//GPoetUtil.print2File(Config.FILE_PATH.RESPONSE, Config.PACKAGE_NAME.RESPONSE, outTb.build())
//GPoetUtil.print2Out(Config.PACKAGE_NAME.RESPONSE, outTb.build())