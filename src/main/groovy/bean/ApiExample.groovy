package bean
/**
 * Created by Administrator on 2017/2/14 0014.
 */
class ApiExample {
    /**
     * title : 正确响应
     * content : HTTP/1.1 204 No Content
     * type : json
     */

    String title;
    String content;
    String type;


    @Override
    public String toString() {
        return """\
bean.ApiExample{
    title='$title',
    content='$content',
    type='$type'
}"""
    }
}
