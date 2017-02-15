package bean;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class HeaderBean {
    /**
     * title :
     * content : <p><strong>使用前请详细阅读 <a href="https://worktile.com/share/pages/80205d75a85b4e7ba3d2fa23e35da0dc">使用前必读</a></strong></p>
     <h2>包含的模块</h2>
     <ul>
     <li>圈子信息</li>
     <li>阅读日记</li>
     <li>班级</li>
     <li>课程</li>
     <li>活动</li>
     <li>聊天信息</li>
     </ul>
     <h2>接口信息</h2>
     <ul>
     <li>协议: HTTPS</li>
     <li>域名: api.baobaobooks.net(开发测试), api.baobaobooks.com(生产)</li>
     <li>模块: readerclub</li>
     <li>最新版本: v1</li>
     <li>Root Endpoint: https://api.baobaobooks.net/readerclub/v1</li>
     </ul>

     */

    public String title;
    public String content;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeaderBean{");
        sb.append("title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
