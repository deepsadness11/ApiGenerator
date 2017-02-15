package util

import bean.ApiBean
import bean.FieldParam
import com.squareup.javapoet.AnnotationSpec
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import global.Config
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import com.squareup.javapoet.ClassName;

import javax.lang.model.element.Modifier
import java.lang.reflect.Type

/**
 * 对应请求方法生成对应的参数
 * Created by Administrator on 2017/2/14 0014.
 */
//判断请求的类型
def addRequestParam(String type, String targetUrl, String methodName, List<FieldParam> paramList, MethodSpec.Builder mb) {
    def c = ClassName.get(Config.PACKAGE_NAME.COMMON, "Common")
    def pathCode = CodeBlock.builder().add('$T._BASE+\"' + "$targetUrl\"", c).build()


    switch (type) {
        case 'get': mb.addAnnotation(AnnotationSpec.builder(GET.class).addMember('value', pathCode).build())
            addGetAndDeleteParam(paramList, mb); break
        case 'post': mb.addAnnotation(AnnotationSpec.builder(POST.class).addMember('value',  pathCode).build())
            addPutAndPostParam(methodName, paramList, mb); break
        case 'delete': mb.addAnnotation(AnnotationSpec.builder(DELETE.class).addMember('value', pathCode).build())
            addGetAndDeleteParam(paramList, mb); break
        case 'put': mb.addAnnotation(AnnotationSpec.builder(PUT.class).addMember('value', pathCode).build())
            addPutAndPostParam(methodName, paramList, mb); break
        default:
            throw new RuntimeException('target method not support now!!')
    }

}


def addCertainReturnType(TypeName response, MethodSpec.Builder mb) {
    ClassName Observable = ClassName.get("rx", "Observable");
    TypeName RxObservable = ParameterizedTypeName.get(Observable, response);
    mb.returns(RxObservable)
}


def String generateMethodDoc(ApiBean op, MethodSpec.Builder method) {
    String url = op.url;
    String title = op.title;
    String name = op.name;
    String group = op.group;
    String version = op.version;
    String description = op.description;
    String filename = op.filename;
    String groupTitle = op.groupTitle;
    String groupDescription = op.groupDescription;
    String totalDoc = "\n" +
            "url= $url\n" +
            "title=$title\n" +
            "name=$name\n" +
            "group=$group\n" +
            "version=$version\n" +
            "description=$description\n" +
            "filename=$filename\n" +
            "groupTitle=$groupTitle\n" +
            "groupDescription=$groupDescription\n\n"

    method.addJavadoc(totalDoc)
    url
}

/**
 *
 * put请求和Post请求默认需要构造body参数。将所有的参数变成一个body.
 * 另外，当参数类型为Binary时，则需要构造MultiPartBody参数
 * @param paramList 实际Query的参数，这里的参数需要移除掉添加在Path里面的参数
 * @param mb 对应方法的MethodSpec.Builder
 */
private def addPutAndPostParam(String methodName, List<FieldParam> paramList, MethodSpec.Builder mb) {
    //1.先判断是否包含有binary类型的参数
    if (null == paramList)
        return

    def isMultiBody = false
    paramList.forEach {
        p ->
            if (p.type == 'Binary') isMultiBody = true
    }
    if (isMultiBody) {
        //如果是MultiBody 则参数一般就是一个Body而言。构造MultiBody相对姜丹
        constructMultiBodyParam(mb)
    } else {
        //如果不是的话，则需要构造一个Param对象，包含所有的参数
        generateRequestBodyParam(methodName, paramList, mb)
    }
}

/**
 * get请求添加的参数最简单，只是单纯的基本数据类型而言
 * @param paramList 实际Query的参数，这里的参数需要移除掉添加在Path里面的参数
 * @param mb 对应方法的MethodSpec.Builder
 *
 */
private def addGetAndDeleteParam(List<FieldParam> paramList, MethodSpec.Builder mb) {
    if (!paramList) return;


    paramList.forEach {
        p ->
            GPoetUtil.addQueryParam(p, mb)

            //添加相应的注释
            String docField = "" +
                    "@param $p.field  $p.description   type= $p.type   isOptional=$p.optional \n"
            mb.addJavadoc(docField)
    }
}

/**
 * 构造MultiBody 的方法参数，用的几率比较小。多用于文件上传
 * @param mb 对应方法的MethodSpec.Builder
 */
private def constructMultiBodyParam(MethodSpec.Builder mb) {

    GPoetUtil.addBodyParamToMethod(MultipartBody.class, 'multipartBody')
//
//    ParameterSpec parameterSpec = ParameterSpec.builder(MultipartBody.class, 'multipartBody')
//            .addModifiers(Modifier.FINAL)
//            .addAnnotation(AnnotationSpec.builder(Body.class).build())
//            .build();
//    mb.addParameter(parameterSpec)

    //添加相应的注释
    String doc = '@param multipartBody multipartBody类参数 type=Binary isOptional=true'
    mb.addJavadoc(doc)

}

/**
 * 生成Body 的方法参数，用的几率比较小。多用于文件上传
 * @param fieldParams 实际Query的参数，这里的参数需要移除掉添加在Path里面的参数
 * @param mb 对应方法的MethodSpec.Builder
 */
private def generateRequestBodyParam(String methodName, List<FieldParam> fieldParams, MethodSpec.Builder mb) {
    //生成对应的类
    //对应的类名。应该是方法名的
    //通过javaPoet生成对应的RequestParam

    String methodNameParamName = generateRequestBodyParamName(methodName)

    ClassName className = GPoetUtil.generateRequestParam(methodNameParamName, fieldParams)

    GPoetUtil.addBodyParamToMethod(className, methodNameParamName.capitalize(), mb)

    //添加相应的注释
    String doc = '@param ' + methodNameParamName.capitalize() + ' 自动生成的Body'
    mb.addJavadoc(doc)
}

/**
 * 生成对应的方法名的参数名
 * @param methodName
 * @return
 */
private def generateRequestBodyParamName(String methodName) {
    String paramName = methodName.concat("RequestParam")
}

