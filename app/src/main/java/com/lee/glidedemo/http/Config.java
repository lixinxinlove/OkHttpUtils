package com.lee.glidedemo.http;

public class Config {

    public static final String BASE_URL = "http://open.inner.evente.cn:30380/1.0/";
    //公网
    //public static final String BASE_URL = "http://piao.inner.evente.cn:30380/1.0/";

    // public static final String BASE_URL = "http://open.inner.evente.cn:30206/1.0/";

    // 线上
   // public static final String BASE_URL = "https://open.evente.cn/1.0/";

    // 请求失败code
    public static final String HTTP_REQUEST_FAILURE = "-1";
    // 请求成功code
    public static final String HTTP_REQUEST_SUCCESS = "0";
    // 请求数据为空
    public static final String HTTP_REQUEST_EMPTY = "1";
    // json解析失败
    public static final String HTTP_REQUEST_JSON_ERROR = "-2";
    // 必传参数
    public static final String REQUEST_METHOD_LAB = "method";
    // 申请的应用ID
    public static final String REQUEST_APPID_LAB = "app_id";
    // 当前时间：date('Y-m-d H:i:s')
    public static final String REQUEST_TIMESTAMP_LAB = "timestamp";
    // 相应信息格式：json
    public static final String REQUEST_FORMAT_LAB = "format";
    // 主办ID lab
    public static final String REQUEST_ORG_ID_LAB = "org_id";
    // 加密方式：md5
    public static final String REQUEST_SIGN_METHOD_LAB = "sign_method";
    // access_token
    public static final String REQUEST_ACCESS_TOKEN_LAB = "access_token";
    // sing
    public static final String REQUEST_SIGN_LAB = "sign";

    public static final String REQUEST_FORMAT_VALUE = "json";

    public static final String REQUEST_SIGN_METHOD_VALUE = "md5";

    // 线下
    public static final String MD5_SECRET = "3mOx8Kzr0Vn2bYphJ7yEepn1NEwPk4eo";
    // 线上
    //public static final String MD5_SECRET = "RO8plD5d0Vve5d9IDRwK7MvPQmjEwA6Y";

    public static final String REQUEST_APPID_VALUE = "10106";

    public static final String REQUEST_SEPARATOR = "";

    public static final String ACCESS_TOKEN = "access_token";

    public static final String EVENT_RUNNING_ACTION = "event.running.action";

    public static final int EVENT_RUNNING_TIME = 1000 * 60 * 5;

    public static final String LOCAL_VERIFICATION_STATE = "android";

    public static final String LAST_Req_Date_KEY = "lastReqDate";
    //版本号
    public static final String VERSION_CODE = "1.0.0";
    // 自己微信应用的 appId
    public static String WX_APP_ID = "wx63bc4bff0e0494ae";
    // 自己微信应用的 appSecret
    public static String WX_SECRET = "482c9ab9bd1398ff669792cf7522ef92";
    /**
     * 分页拉票的数量
     */
    public static int size = 2000;

    public static final String WEIBO_APP_ID = "1670021049";

    public static final String WEIBO_REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";

    public static final String HTTP_KEY_LAB = "http_key";

    public static final String WEIBO_SCOPE = "email,direct_messages_read,direct_messages_write,"
            + "friendships_groups_read,friendships_groups_write,statuses_to_me_read," + "follow_app_official_microblog,"
            + "invitation_write";

    public static final String TALKING_DATA_ID = "F9D962D59DE64999B9CB335ABFA1C1E7";

    public static final String TD_CHANNEL_ID = "pgyer";

    public static final String JPUSH_MSG_ACTION = "com.eventmosh.evente.push_msg";
}
