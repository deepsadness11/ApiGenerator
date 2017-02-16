package global;

/**
 * Created by Administrator on 2017/2/14 0014.
 */
public class Config {


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
        public static String TOTAL_PATH = "d://gn";
        public static String REQUEST = TOTAL_PATH;
        public static String RESPONSE = TOTAL_PATH;
        public static String SERVICE = TOTAL_PATH;
        public static String COMMON = TOTAL_PATH;
    }
}
