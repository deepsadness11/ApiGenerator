package bean
/**
 * Api 请求的参数的对象
 * Created by Administrator on 2017/2/14 0014.
 */
class ApiParameter {

    /**
     * fields : {"Parameter":[{"group":"Parameter","type":"Integer","optional":false,"field":"content_id","description":"<p>日记id<\/p>"}]}*/

    ApiField fields;

    @Override
    public String toString() {
        return """\
bean.ApiParameter{
    fields=$fields
}"""
    }
}
