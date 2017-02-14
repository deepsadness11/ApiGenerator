package bean
/**
 * Api的返回对象
 * Created by Administrator on 2017/2/14 0014.
 */
class ApiList {
    List<ApiBean> api

    @Override
    public String toString() {
        return """\
bean.ApiList{
    apiList=$api
}"""
    }
}
