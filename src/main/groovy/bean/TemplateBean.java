package bean;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class TemplateBean {
    /**
     * forceLanguage : zh_cn
     * withCompare : true
     * withGenerator : true
     * jQueryAjaxSetup : {"headers":{"X-HB-Client-Type":"haibao-ios","X-HB-Auth-Type":"token","Authorization":"HBAPI MzY4NDU6MWJmNTAxOTUxNWMyMzM5ZmY3NTE3NTE4ZTQyYzNhMmQ="}}
     */

    public String forceLanguage;
    public boolean withCompare;
    public boolean withGenerator;
    public JQueryAjaxSetupBean jQueryAjaxSetup;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TemplateBean{");
        sb.append("forceLanguage='").append(forceLanguage).append('\'');
        sb.append(", withCompare=").append(withCompare);
        sb.append(", withGenerator=").append(withGenerator);
        sb.append(", jQueryAjaxSetup=").append(jQueryAjaxSetup);
        sb.append('}');
        return sb.toString();
    }
}
