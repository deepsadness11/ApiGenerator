import bean.PrjBean
import com.google.gson.Gson
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.TypeSpec
import global.Config
import util.GApiUtil
import util.GPoetUtil

import javax.lang.model.element.Modifier


/**
 * Created by Administrator on 2017/2/15 0015.
 */


def static start(String address) {
    println "开始网络请求。。。"
    def content = GApiUtil.GET_API(address)
    println "网络请求结束，处理中。。。"
    def proInfo = new Gson().fromJson(GApiUtil.GET_API_JSON2Real(content), PrjBean.class)

    def xml = proInfo.header.content

//写入本地

    def real = "<pack>$xml</pack>"
    def langs = new XmlParser().parseText(real)

    def ul = langs.ul

    def a = langs.ul[ul.size() - 1].li

    def moduleName = a[2].text().split(' ').last()
    String version = a[3].text().split(' ').last()

    def bigMName = "$moduleName".capitalize()
    def verName = "$bigMName".toUpperCase() + "_VERSION"
    def mmName = "$moduleName".toUpperCase()

    def mm = FieldSpec.builder(String.class, mmName)
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
            .initializer('$S', "$moduleName")
            .build()

    def ver = FieldSpec.builder(String.class, verName)
            .initializer('$S', "$version")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
            .build()

//String SMS_BASE = "sms/" + SMS_VERSION + "/";
//"$moduleName".toUpperCase() + '_BASE'
    def base = FieldSpec.builder(String.class, '_BASE')
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
//            .initializer('$S', "$moduleName" + "/$version/")
            .initializer("$mmName+\"/\"+$verName+\"/\"")
            .build()


//生成Common文件
    Config.COMMON_FILE_NAME = bigMName + "Common"

//    def MeAnno = ClassName.get('com.example.inter.ApiFactory', 'ApiFactory')
    TypeSpec common = TypeSpec.interfaceBuilder(Config.COMMON_FILE_NAME)
            .addModifiers(Modifier.PUBLIC)
            .addField(mm)
            .addField(ver)
            .addField(base)

//    .addAnnotation(AnnotationSpec.builder(MeAnno).build())

            .build()



    GPoetUtil.print2File(Config.FILE_PATH.COMMON, Config.PACKAGE_NAME.COMMON, common)
//    GPoetUtil.print2Out(Config.PACKAGE_NAME.COMMON, common)


}

//start()