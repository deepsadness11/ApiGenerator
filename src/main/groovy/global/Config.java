package global;

/**
 * Created by Administrator on 2017/2/14 0014.
 */
public interface Config {

    String API_DEV_URL = "http://apidev.baobaobooks.net/docs/readerclub/api_data.js?v=1487067289562";
    String API_URL = "http://apidev.baobaobooks.net/docs/readerclub/api_data.js?v=1487067289562";

    String API_CACHE_FILE_NAME = "apiJson";
    /**
     * 是否从网上重新请求。网上请求会缓存到本地
     */
    boolean FROM_NET = false;

    interface PACKAGE_NAME {
        String REQUEST_PARAM = "";
        String RESPONSE_PARAM = "";
        String SERVICE = "";
    }

    interface FILE_PATH {
        String REQUEST_PATH = "d://ag//request";
        String RESPONSE_PATH = "d://ag//response";
        String SERVICE_PATH = "d://ag";
    }
}
