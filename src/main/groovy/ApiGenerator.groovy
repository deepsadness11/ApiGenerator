import bean.ApiBean
import com.squareup.javapoet.AnnotationSpec
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec
import global.Config
import util.GApiUtil
import util.GMethodUtil
import util.GPoetUtil
import util.GUrlUtil
import util.circleParse;

import javax.lang.model.element.Modifier

/**
 * 执行的ApiGenerator的Groovy类
 * Created by Administrator on 2017/2/14 0014.
 */

//--------------->>1.获取实际的ApiJson
/**
 * 实际Api字符串
 */

def static start(String address) {
    def realApiResponseJson
    if (Config.FROM_NET) {
        //Api的地址
        realApiResponseJson = GApiUtil.GET_API_JSON(address)
        //保存到本地

//    GApiUtil.GET_JSON2FILE(realApiResponseJson)
    } else {
        //从离线缓存中获取
        realApiResponseJson = GApiUtil.GET_FILE2String()
    }

//--------------->>2.通过Gson转化成Api对象
    def apiList = GApiUtil.CONVERT_TO_LIST(realApiResponseJson)

//def apiList = GApiUtil.CONVERT_TO_LIST(realApiResponseJson)

//--------------->>打印检查
//apiList.api.forEach {
//    apiBean ->
//        //得到正确的返回。使用处理的json字符串
//        util.GApiUtil.printlnProperties(apiBean)
//}

//util.GApiUtil.printlnProperties(apiList.api[4])

//后面完成分部分
    TypeSpec.Builder totalClass;
//--------------->>开始对单个工作
//得到成功的返回
    def tempOpGroup
    def circleMechine = new circleParse()
    apiList.api.forEach {
        op ->
            //如果不相等
            if (op.group != tempOpGroup) {
                if (totalClass != null) {
                    //生成类
                    def MeAnno = ClassName.get('com.example.inter', 'ApiFactory')
                    totalClass.addAnnotation(AnnotationSpec.builder(MeAnno).build())
                    GPoetUtil.print2File(Config.FILE_PATH.SERVICE, Config.PACKAGE_NAME.SERVICE, totalClass.build())
                }
                tempOpGroup = op.group
                String apiServiceName = "$tempOpGroup" + "ApiService"
//            println apiServiceName
                totalClass = TypeSpec.interfaceBuilder(apiServiceName.capitalize())
                        .addModifiers(Modifier.PUBLIC)
            }

            operateOnEachApiBean(op, totalClass)
    }

    //给TotalClass 添加自定义的注解
    def MeAnno = ClassName.get('com.example.inter.ApiFactory', 'ApiFactory')
    totalClass.addAnnotation(AnnotationSpec.builder(MeAnno).build())

//    GPoetUtil.print2Out(Config.PACKAGE_NAME.SERVICE, totalClass.build())
    //循环结束也需要创建
    GPoetUtil.print2File(Config.FILE_PATH.SERVICE, Config.PACKAGE_NAME.SERVICE, totalClass.build())
//先创建类。暂时不分部分。
}

def static operateOnEachApiBean(ApiBean op, TypeSpec.Builder totalClass) {

//得到对应的方法名和类名
    def methodName = op.name.split("_").collect { it.capitalize() }.join("")
    def responseName = methodName.concat("Response")
    def type = op.type

    def methodAdd = new GMethodUtil()

/*
---->>开始生成对应方法
 */
    MethodSpec.Builder method = MethodSpec.methodBuilder(methodName)
            .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)

//0.添加方法的说明
    String url = methodAdd.generateMethodDoc(op, method)

//1.需要先对url进行判断
//def url = op.url
//对url进行操作
    def urlU = new GUrlUtil()
    def targetUrl = urlU.generateUrl(url)
    def urlParamList = urlU.filterPathParam(targetUrl)
//生成拼接的参数
    urlParamList.forEach {
        String p -> GPoetUtil.addPathAnnotation(p, method)
    }

//2.对请求的参数根据请求的方式进行生成

//先将参数处理掉
    def totalParam = op.parameter?.fields?.Parameter

    if (urlParamList) {
        println 'sdfsf'
    }

    if (totalParam) {
        for (int i = 0; i < totalParam.size(); i++) {
            for (int j = 0; j < urlParamList.size(); j++) {
                if (totalParam.get(i).field == urlParamList[j]) {
                    totalParam.remove(i)
                    urlParamList.remove(j)
                }
            }
        }
    }

    methodAdd.addRequestParam(type, targetUrl, methodName, totalParam, method)

    if (op == null) {
        println 'object is null'
        return
    }
    if (op.success == null) {
        println op
        println 'object success is null'
        return
    }

    if (op.success.examples == null) {
        println op.success
        println 'object success example is null'
        return
    }

    if (op.success.examples[0] == null) {
        println op.success.examples
        println 'object success example list is null'
        return
    }
//生成返回对象
    List<ClassName> responseClass = GPoetUtil.generateResponseClass(op.success.examples[0], responseName);

    responseClass.forEach {
        res ->//添加返回值
            methodAdd.addCertainReturnType(res, method)

    }

//添加方法的注释
    totalClass.addMethod(method.build())
/*
------>>完成对应的方法
 */
}

//获取项目的配置文件

