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
def content = GApiUtil.GET_API(Config.API_PROJECT_DEV_URL_READ)

def proInfo = new Gson().fromJson(GApiUtil.GET_API_JSON2Real(content), PrjBean.class)

def xml = proInfo.header.content

//写入本地

def real = "<pack>$xml</pack>"
def langs = new XmlParser().parseText(real)

def a = langs.ul[1].li

def moduleName = a[2].text().split(' ').last()
String version = a[3].text().split(' ').last()

def bigMName = "$moduleName".capitalize()


def mm = FieldSpec.builder(String.class, "$moduleName".toUpperCase())
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
        .initializer('$S', "$moduleName")
        .build()

//String SMS_BASE = "sms/" + SMS_VERSION + "/";
//"$moduleName".toUpperCase() + '_BASE'
def base = FieldSpec.builder(String.class, '_BASE')
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
        .initializer('$S', "$moduleName" + "/$version/")
        .build()

def ver = FieldSpec.builder(String.class, "$bigMName".toUpperCase() + "_VERSION")
        .initializer('$S', "$version")
        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
        .build()
//生成Common文件
bigMName + "Common"
TypeSpec common = TypeSpec.interfaceBuilder("Common")
        .addModifiers(Modifier.PUBLIC)
        .addField(mm)
        .addField(base)
        .addField(ver)
        .build()
GPoetUtil.print2File(Config.FILE_PATH.COMMON, Config.PACKAGE_NAME.COMMON, common)



