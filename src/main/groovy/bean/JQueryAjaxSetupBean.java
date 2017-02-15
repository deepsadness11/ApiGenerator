package bean;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class JQueryAjaxSetupBean {
    /**
     * headers : {"X-HB-Client-Type":"haibao-ios","X-HB-Auth-Type":"token","Authorization":"HBAPI MzY4NDU6MWJmNTAxOTUxNWMyMzM5ZmY3NTE3NTE4ZTQyYzNhMmQ="}
     */

    public HeadersBean headers;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JQueryAjaxSetupBean{");
        sb.append("headers=").append(headers);
        sb.append('}');
        return sb.toString();
    }
}
