package bean
/**
 * Created by Administrator on 2017/2/14 0014.
 */
class ApiBean {

    /**
     * type : put
     * url : /contents/:content_id/like
     * title : 点赞日记
     * name : put_contents__content_id_like
     * group : content
     * version : 1.0.0
     * permission : [{"name":"token","title":"需要用户登录","description":"<p>需要在header中传递Authorization，详情参考\u201c使用前必读\u201d-\u201c公共参数\u201d<\/p>"}]
     * description : <p>对日记进行点赞</p>
     * parameter : {"fields":{"Parameter":[{"group":"Parameter","type":"Integer","optional":false,"field":"content_id","description":"<p>日记id<\/p>"}]}}* success : {"examples":[{"title":"正确响应","content":"HTTP/1.1 204 No Content","type":"json"}]}* error : {"fields":{"404":[{"group":"404","optional":false,"field":"NotFound","description":"<p>请求的资源不存在<\/p>"}],"错误 4xx":[{"group":"4xx","optional":false,"field":"InvalidToken","description":"<p>未登录或授权过期，请登录<\/p>"}]},"examples":[{"title":"NotFound:","content":"HTTP/1.1 404 Not Found\n{\n  \"code\": \"NotFound\",\n  \"message\": \"请求的资源不存在\"\n}","type":"json"},{"title":"InvalidToken:","content":"HTTP/1.1 401 Unauthorized\n{\n  \"code\": \"InvalidToken\",\n  \"message\": \"未登录或授权过期，请登录\"\n}","type":"json"}]}* filename : readerclub/v1/content.php
     * groupTitle : 阅读日记
     * groupDescription : <p>日记内容相关,包括点赞、评论等</p>
     */
    String type;
    String url;
    String title;
    String name;
    String group;
    String version;
    String description;
    String filename;
    String groupTitle;
    String groupDescription;
    ApiParameter parameter;
    ApiSuccess success;


    @Override
    public String toString() {
        return """\
bean.ApiBean{
    type='$type',
    url='$url',
    title='$title',
    name='$name',
    group='$group',
    version='$version',
    description='$description',
    filename='$filename',
    groupTitle='$groupTitle',
    groupDescription='$groupDescription',
    parameter=$parameter,
    success=$success
}"""
    }
}
