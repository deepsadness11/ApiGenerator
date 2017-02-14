package util

import bean.ApiList
import com.google.gson.Gson
import global.Config


/**
 * 处理Api网络请求转化的类
 * Created by Administrator on 2017/2/14 0014.
 */

//将网址转成String
static String GET_API(String address) {
    return new URL(address).openStream().text
}

//将网址转成想要的String
static String GET_API_JSON(String address) {
    def apiString = GET_API(address)
    GET_API_JSON2Real(apiString)
}

//将网址转成想要的String
static String GET_API_JSON2Real(String apiString) {
    def startIndex = apiString.indexOf("(")
    def endIndex = apiString.lastIndexOf(")")
    if (startIndex == -1) return apiString
    else apiString.substring(startIndex + 1, endIndex)
}

//将其保存在文件中
static GET_API2FILE(String address) {
    def out = new BufferedOutputStream(new FileOutputStream(Config.API_CACHE_FILE_NAME))
    out << new URL(address).openStream()
}

//将其保存在本地中
static GET_JSON2FILE(String apiString) {
    new File(Config.API_CACHE_FILE_NAME).write(apiString)
}

//将其保存在文件中
static GET_FILE2String() {
    GET_API_JSON2Real(new File(Config.API_CACHE_FILE_NAME).text)
}


static ApiList CONVERT_TO_LIST(String apiJson) {
    return new Gson().fromJson(apiJson, ApiList.class)
}

//打印属性
static printlnProperties(apiBean) {
//    apiBean ->
    //得到正确的返回。使用处理的json字符串
    apiBean?.success?.examples?.forEach {
        ep -> println 'examples content===' + ep.content
    }
    //得到输入的参数。有可能为空
    apiBean.parameter.fields.Parameter?.forEach {
        pa ->
            println 'Parameter description===' + pa.description
            println 'Parameter type====' + pa.type
            println 'Parameter field====' + pa.field
            println 'Parameter group===' + pa.group
            println 'Parameter optional===' + pa.optional
    }
    //得到api的描述
    println 'apiBean description===' + apiBean.description
    println 'apiBean title===' + apiBean.title
    println 'apiBean url===' + apiBean.url
    println 'apiBean type===' + apiBean.type
}

