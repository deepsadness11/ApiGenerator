package bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class PrjBean {

    /**
     * name : 阅读圈模块
     * version : 1.0.0
     * description : 孩宝小镇阅读圈相关接口,同时孩宝U站App阅读圈部分复用
     * title : 阅读圈模块-孩宝API
     * url :
     * sampleUrl : https://api.baobaobooks.net/readerclub/v1
     * header : {"title":"","content":"<p><strong>使用前请详细阅读 <a href=\"https://worktile.com/share/pages/80205d75a85b4e7ba3d2fa23e35da0dc\">使用前必读<\/a><\/strong><\/p>\n<h2>包含的模块<\/h2>\n<ul>\n<li>圈子信息<\/li>\n<li>阅读日记<\/li>\n<li>班级<\/li>\n<li>课程<\/li>\n<li>活动<\/li>\n<li>聊天信息<\/li>\n<\/ul>\n<h2>接口信息<\/h2>\n<ul>\n<li>协议: HTTPS<\/li>\n<li>域名: api.baobaobooks.net(开发测试), api.baobaobooks.com(生产)<\/li>\n<li>模块: readerclub<\/li>\n<li>最新版本: v1<\/li>\n<li>Root Endpoint: https://api.baobaobooks.net/readerclub/v1<\/li>\n<\/ul>\n"}
     * footer : {"title":"","content":"<center>Shenzhen Caldecott Cultural Communications Co.,Ltd.<\/center>\n<center>© 2009-2016 深圳市凯迪克文化传播有限公司版权所有，仅限内部使用，禁止传播 粤ICP备12087424号<\/center>"}
     * template : {"forceLanguage":"zh_cn","withCompare":true,"withGenerator":true,"jQueryAjaxSetup":{"headers":{"X-HB-Client-Type":"haibao-ios","X-HB-Auth-Type":"token","Authorization":"HBAPI MzY4NDU6MWJmNTAxOTUxNWMyMzM5ZmY3NTE3NTE4ZTQyYzNhMmQ="}}}
     * order : ["club","content","activity","class","course","search","chat","post_clubs","put_clubs__club_id","get_clubs__club_id","get_clubs__club_id_messages_unread_number","put_clubs__club_id_messages_unread","get_clubs__club_id_users","get_clubs_recommended","put_clubs__club_id_applications","delete_clubs__club_id_users__user_id","get_contents","get_clubs__club_id_contents","get_topics__topic_id_contents","get_clubs__club_id_topics__topic_id_contents","get_users__user_id_contents","get_user_contents","post_contents","post_contents_images","post_contents_cover","put_contents__content_id","delete_contents__content_id","get_contents__content_id","get_contents__content_id_like_users","put_contents__content_id_like","delete_contents__content_id_like","get_contents__content_id_comments","post_contents__content_id_comments","delete_contents__content_id_comments__comment_id","post_activities","put_activities__activity_id","post_activities_cover","delete_activities__activity_id","get_clubs__club_id_activities","get_user_activities","get_activities__activity_id","put_activities__activity_id_applications","post_clubs__club_id_classes","put_clubs__club_id_classes__class_id","delete_clubs__club_id_classes__class_id","post_clubs__club_id_classes_images","get_user_clubs__club_id_classes","get_clubs__club_id_classes","put_clubs__club_id_classes__class_id_users__user_id","delete_clubs__club_id_classes__class_id_users__user_id","get_clubs__club_id_classes__class_id","get_clubs__club_id_classes__class_id_users","post_courses","put_courses__course_id","delete_courses__course_id","post_courses_images","post_courses__course_id_courseware","put_courses__course_id_courseware__courseware_id","delete_courses__course_id_courseware__courseware_id","get_courses__course_id_courseware","get_classes__class_id_courses","get_courses__course_id","put_subscription_courses__course_id","delete_subscription_courses__course_id","put_courses__course_id_learning","get_users__user_id_courses","get_search_contents","get_search_goods","get_search_activities","get_search_courses","get_search_users","post_chat_groups","put_chat_groups__group_id","post_chat_images","get_chat_groups__group_id","delete_chat_groups__group_id","get_chat_groups__group_id_users","put_chat_groups__group_id_users","delete_chat_groups__group_id_users","post_chat_chatrooms","put_chat_chatrooms__chatroom_id","delete_chat_chatrooms__chatroom_id","put_chat_chatrooms__chatroom_id_mute","delete_chat_chatrooms__chatroom_id_mute","put_chat_chatrooms__chatroom_id_users__user_id_mute","delete_chat_chatrooms__chatroom_id_users__user_id_mute"]
     * apidoc : 0.2.0
     * generator : {"name":"apidoc","time":"2017-02-15T08:34:10.642Z","url":"http://apidocjs.com","version":"0.16.1"}
     */

    public String name;
    public String version;
    public String description;
    public String title;
    public String url;
    public String sampleUrl;
    public HeaderBean header;
    public FooterBean footer;
    public TemplateBean template;
    public String apidoc;
    public GeneratorBean generator;
    public List<String> order;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrjBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", sampleUrl='").append(sampleUrl).append('\'');
        sb.append(", header=").append(header);
        sb.append(", footer=").append(footer);
        sb.append(", template=").append(template);
        sb.append(", apidoc='").append(apidoc).append('\'');
        sb.append(", generator=").append(generator);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
