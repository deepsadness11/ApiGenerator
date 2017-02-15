package bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15 0015.
 */
public class te {

    /**
     * next : 11
     * items : [{"content_id":2,"title":"","content_type":1,"summary":"","create_at_format":"","is_open":1,"is_html":0,"audio_url":"","video":{"cover":"","width":1920,"height":1080,"url_f10":"","url_f20":"","url_f30":""},"duration_format":"","images":[{"url":"","thumb_url":""}],"binded_goods":{"goods_id":23,"goods_name":"","goods_thumb":"","shop_url":""},"topic":{"topic_id":12,"content":"","type":2,"type_id":23},"like_status":1,"like_count":23,"user":{"user_id":234,"user_name":"username","avatar":"url","is_lecturer":0,"is_promoter":1,"frient_status":1},"baby":{"baby_id":23,"baby_name":"宝宝名称","age_desc":"1岁","gender":1},"comments_count":23,"latest_comments":[{"comment_id":23,"content":"","audio_url":"","audio_duration_format":"00:8:00","create_at_format":"1小时前","user_id":2,"user_name":"","user_avatar":"","to_user_id":3,"to_user_name":"","to_user_avatar":""}]}]
     */

    public int next;
    public List<ItemsBean> items;

    public static class ItemsBean {
        /**
         * content_id : 2
         * title :
         * content_type : 1
         * summary :
         * create_at_format :
         * is_open : 1
         * is_html : 0
         * audio_url :
         * video : {"cover":"","width":1920,"height":1080,"url_f10":"","url_f20":"","url_f30":""}
         * duration_format :
         * images : [{"url":"","thumb_url":""}]
         * binded_goods : {"goods_id":23,"goods_name":"","goods_thumb":"","shop_url":""}
         * topic : {"topic_id":12,"content":"","type":2,"type_id":23}
         * like_status : 1
         * like_count : 23
         * user : {"user_id":234,"user_name":"username","avatar":"url","is_lecturer":0,"is_promoter":1,"frient_status":1}
         * baby : {"baby_id":23,"baby_name":"宝宝名称","age_desc":"1岁","gender":1}
         * comments_count : 23
         * latest_comments : [{"comment_id":23,"content":"","audio_url":"","audio_duration_format":"00:8:00","create_at_format":"1小时前","user_id":2,"user_name":"","user_avatar":"","to_user_id":3,"to_user_name":"","to_user_avatar":""}]
         */

        public int content_id;
        public String title;
        public int content_type;
        public String summary;
        public String create_at_format;
        public int is_open;
        public int is_html;
        public String audio_url;
        public VideoBean video;
        public String duration_format;
        public BindedGoodsBean binded_goods;
        public TopicBean topic;
        public int like_status;
        public int like_count;
        public UserBean user;
        public BabyBean baby;
        public int comments_count;
        public List<ImagesBean> images;
        public List<LatestCommentsBean> latest_comments;

        public static class VideoBean {
            /**
             * cover :
             * width : 1920
             * height : 1080
             * url_f10 :
             * url_f20 :
             * url_f30 :
             */

            public String cover;
            public int width;
            public int height;
            public String url_f10;
            public String url_f20;
            public String url_f30;
        }

        public static class BindedGoodsBean {
            /**
             * goods_id : 23
             * goods_name :
             * goods_thumb :
             * shop_url :
             */

            public int goods_id;
            public String goods_name;
            public String goods_thumb;
            public String shop_url;
        }

        public static class TopicBean {
            /**
             * topic_id : 12
             * content :
             * type : 2
             * type_id : 23
             */

            public int topic_id;
            public String content;
            public int type;
            public int type_id;
        }

        public static class UserBean {
            /**
             * user_id : 234
             * user_name : username
             * avatar : url
             * is_lecturer : 0
             * is_promoter : 1
             * frient_status : 1
             */

            public int user_id;
            public String user_name;
            public String avatar;
            public int is_lecturer;
            public int is_promoter;
            public int frient_status;
        }

        public static class BabyBean {
            /**
             * baby_id : 23
             * baby_name : 宝宝名称
             * age_desc : 1岁
             * gender : 1
             */

            public int baby_id;
            public String baby_name;
            public String age_desc;
            public int gender;
        }

        public static class ImagesBean {
            /**
             * url :
             * thumb_url :
             */

            public String url;
            public String thumb_url;
        }

        public static class LatestCommentsBean {
            /**
             * comment_id : 23
             * content :
             * audio_url :
             * audio_duration_format : 00:8:00
             * create_at_format : 1小时前
             * user_id : 2
             * user_name :
             * user_avatar :
             * to_user_id : 3
             * to_user_name :
             * to_user_avatar :
             */

            public int comment_id;
            public String content;
            public String audio_url;
            public String audio_duration_format;
            public String create_at_format;
            public int user_id;
            public String user_name;
            public String user_avatar;
            public int to_user_id;
            public String to_user_name;
            public String to_user_avatar;
        }
    }
}
