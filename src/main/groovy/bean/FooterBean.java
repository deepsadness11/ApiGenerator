package bean;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class FooterBean {
    /**
     * title :
     * content : <center>Shenzhen Caldecott Cultural Communications Co.,Ltd.</center>
     <center>© 2009-2016 深圳市凯迪克文化传播有限公司版权所有，仅限内部使用，禁止传播 粤ICP备12087424号</center>
     */

    public String title;
    public String content;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FooterBean{");
        sb.append("title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
