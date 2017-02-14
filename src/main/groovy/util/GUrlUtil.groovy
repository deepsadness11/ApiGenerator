package util
/**
 * 生成url的工具类
 * Created by Administrator on 2017/2/14 0014.
 */

//生成想要的url
def generateUrl(String originUrl) {
    //1.先省略？结尾的参数
    def tempS = ignoreQuestionMark(originUrl)

    //2、先检查':'字符
    putToList(tempS).collect().join('/')

}

//将{}的过滤出来。添加参数
def filterPathParam(String targetUrl) {
    def result = []
    targetUrl.tokenize('/').forEach {
        s ->
            if (s.startsWith("{")) {
                s = s.substring(1, s.length() - 1)
                result.add(s)
            }
    }
    result
}

//将变量存到数组里面
private def putToList(String a) {
    def resultList = []
    def index = 0
    a.tokenize('/').forEach {
        s ->
            def result = changeToParam(s)
            if (result) resultList[index] = result
            index++
    }
    resultList
}

//字符串替换
private def changeToParam(String s) {
    if (s?.contains(':')) {
        s = s.replace(':', '{')
        s = s.concat('}')
    }
    return s
}

private def ignoreQuestionMark(String originUrl) {
    if (originUrl.contains('?')) {
        def endIndex = originUrl.indexOf('?')
        originUrl = originUrl.substring(0, endIndex)
    }
    originUrl
}