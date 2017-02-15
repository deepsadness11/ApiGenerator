package bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class HeadersBean {
    /**
     * X-HB-Client-Type : haibao-ios
     * X-HB-Auth-Type : token
     * Authorization : HBAPI MzY4NDU6MWJmNTAxOTUxNWMyMzM5ZmY3NTE3NTE4ZTQyYzNhMmQ=
     */

    @SerializedName("X-HB-Client-Type")
    public String XHBClientType;
    @SerializedName("X-HB-Auth-Type")
    public String XHBAuthType;
    public String Authorization;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeadersBean{");
        sb.append("XHBClientType='").append(XHBClientType).append('\'');
        sb.append(", XHBAuthType='").append(XHBAuthType).append('\'');
        sb.append(", Authorization='").append(Authorization).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
