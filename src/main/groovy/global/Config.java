package global;

/**
 * Created by Administrator on 2017/2/14 0014.
 */
public class Config {

    public static final String API_DATA_DEV_READER = "http://apidev.baobaobooks.net/docs/readerclub/api_data.js?v=1487067289562";
    public static final String API_PROJ_DEV_READER = "http://apidev.baobaobooks.net/docs/readerclub/api_project.js?v=1487151780547";
    public static final String API_PROJ_DEV_BOOKSHELF = "http://apidev.baobaobooks.net/docs/bookshelf/api_project.js?v=1487158608795";
    public static final String API_DATA_DEV_BOOKSHELF = "http://apidev.baobaobooks.net/docs/bookshelf/api_data.js?v=1487158608795";
    public static final String API_DATA_DEV_USER = "http://apidev.baobaobooks.net/docs/user/api_data.js?v=1487158747269";
    public static final String API_PROJ_DEV_USER = "http://apidev.baobaobooks.net/docs/user/api_project.js?v=1487158747269";
//    String API_DATA_DEV_USER = "http://apidev.baobaobooks.net/docs/user/api_project.js?v=1487158747269";
//    String API_PROJ_DEV_USER = "http://apidev.baobaobooks.net/docs/user/api_project.js?v=1487158747269";


    public static String API_CACHE_FILE_NAME = "apiJson";
    /**
     * 是否从网上重新请求。网上请求会缓存到本地
     */
    public static boolean FROM_NET = true;
    /**
     * 通过请求后生成
     */
    public static String COMMON_FILE_NAME = "Common";


    public static class PACKAGE_NAME {
        public static String TOTAL_PACKAGE = "com.base.basesdk.data";
        public static String REQUEST = TOTAL_PACKAGE + ".param";
        public static String RESPONSE = TOTAL_PACKAGE + ".response";
        public static String SERVICE = TOTAL_PACKAGE + ".http.service";
        public static String COMMON = TOTAL_PACKAGE + ".http.common";
    }

    public static class FILE_PATH {
        public static String TOTAL_PATH = "d://ag";
        public static String REQUEST = TOTAL_PATH;
        public static String RESPONSE = TOTAL_PATH;
        public static String SERVICE = TOTAL_PATH;
        public static String COMMON = TOTAL_PATH;
    }
}
