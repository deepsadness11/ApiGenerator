package bean;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class GeneratorBean {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeneratorBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * name : apidoc
     * time : 2017-02-15T08:34:10.642Z
     * url : http://apidocjs.com
     * version : 0.16.1
     */


    public String name;
    public String time;
    public String url;
    public String version;
}
