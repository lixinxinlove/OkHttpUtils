package okhttp;

public class ChimelongConfig {

	// public static final String BASE_URL =
	// "http://newapi.inner.evente.cn:30315?";

	// public static final String BASE_URL = "http://api.lab.evente.cn?";
	public static final String BASE_URL = "https://api.evente.cn?";
	// 请求失败code
	public static final String HTTP_REQUEST_FAILURE = "-1";
	// 请求成功code
	public static final String HTTP_REQUEST_SUCCESS = "0";
	// json解析失败
	public static final String HTTP_REQUEST_JSON_ERROR = "-2";
	// 必传参数
	public static final String REQUEST_METHOD_LAB = "method";

	public static final String REQUEST_V_LAB = "v";

	public static final String REQUEST_TIMESTAMP_LAB = "timestamp";

	public static final String REQUEST_FORMAT_LAB = "format";

	public static final String REQUEST_CLIENT_TYPE_LAB = "client_type";

	public static final String REQUEST_CLIENT_TYPE_VALUE = "2";

	public static final String REQUEST_APPID_LAB = "app_id";
	// 线上
	public static final String REQUEST_APPID_VALUE = "10102";
	// 测试
	// public static final String REQUEST_APPID_VALUE = "10001";
	// 主办ID lab
	public static final String REQUEST_ORG_ID_LAB = "org_id";
	// 线上
	public static final String REQUEST_ORG_ID_VALUE = "10035";
	// 测试
	// public static final String REQUEST_ORG_ID_VALUE = "67";

	// public static final String REQUEST_ORG_ID_VALUE = "10040";
	// public static final String REQUEST_ORG_ID_VALUE = "10060";

	public static final String REQUEST_SIGN_METHOD_LAB = "sign_method";

	public static final String REQUEST_SIGN_LAB = "sign";

	public static final String REQUEST_V_VALUE = "1.0.34";

	public static final String REQUEST_FORMAT_VALUE = "json";

	public static final String REQUEST_SIGN_METHOD_VALUE = "md5";

	public static final String REQUEST_USER_TOKEN = "token";

	public static final String REQUEST_UNIQUE_ID = "unique_id";
	// 线上
	public static final String MD5_SECRET = "RO8plD5d0PQmjEwA6Y";
	// c测试
	// public static final String MD5_SECRET = "8fe225620e8fc26d628";

	public static final String DATE_Y_M_D_FORMAT = "yyyy-MM-dd";

	public static final String DATE_Y_M_D_FORMAT_2 = "yyyy年MM月dd�?";

	public static final String DATE_M_D_FORMAT = "MM-dd";

	public static final String DATE_M_D_FORMAT_1 = "MM月dd�?";

	// public static final String CHIMELONG_USER_IMG = "chimelong_user_img";

	public static final String SYSTEM_SETTING_3GSHOW_IMG = "system_setting_3gshow_img";

	public static final String SYSTEM_SETTING_MSG_PUSH = "system_setting_msg_push";

	public static final String WECHAT_APP_ID = "wx2a9c8cb6ec27fdfd";

	public static final String WECHAT_APP_SECRET = "f7a83a293904b6146ed58fd8c025b575";

	public static final String WEIBO_APP_ID = "1176177467";

	public static final String WEIBO_REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";

	public static final String HTTP_KEY_LAB = "http_key";

	public static final String WEIBO_SCOPE = "email,direct_messages_read,direct_messages_write,"
			+ "friendships_groups_read,friendships_groups_write,statuses_to_me_read," + "follow_app_official_microblog,"
			+ "invitation_write";
	public static final String QQ_APP_ID = "100341914";

	public static final String ACTION_UPDATEUI = "action.updateUI";

	// 门票二维码获取后通知详情修改状�??
	public static final String ACTION_FETCH_STATUS = "action.fetchstatus";

	// 门票改期后�?�知详情从新加载
	public static final String ACTION_SCENIC_RESCHEDULE = "action.scenic.reschedule";

	public static final String TRAFFIC_GUIDE = "traffictuide_";

	public static final String RECOMMENDED_ROUTE = "recommendedroute_";

	public static final String VISITORNOTICE = "visitornotice_";

	public static final String HTML_FRAME_BOX_START = "<head><meta http-equiv=\"Content-Type\"content=\"text/html; charset=UTF-8\"><meta name = \"viewport\"content=\"width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0\"><meta name = \"format-detection\"content=\"telephone = no\"><title>编辑�?</title><style>body,div,p,span,a,section,article,li,em,ul,dt,dd,dl,ol{margin:0; padding:0; word-break:break-all !important; work-wrap:break-word !important; white-space:inherit !important}.frame-box	{width:94%; margin:0 auto;overflow:hidden}.frame-box img{ margin:10px auto; display:block; max-width:100% !important;}</style></head><body><div class=\"frame-box\">";

	public static final String HTML_FRAME_BOX_END = "</div></body></html>";

	public static final String HOTEL_LIST = "hotel_list_";

	public static final String SCENIC_LIST = "scenic_list_";

	public static final int TEXT_AOTU_STEP = 4;

	public static final String TALKING_DATA_APP_ID = "AA5ACE1BDBD4566D76A46B3A0ADF3C8A";

	public static final String BOOKING = "<center><h4>酒店预订须知</h4></center>"
			+ "&nbsp;1、酒店正常入住时间为下午15:00,�?房时间为中午12:00�?<br>	" + "&nbsp;2、不�?16周岁未成年人入住酒店必须有成人陪同办理�??<br>	"
			+ "&nbsp;3、客房预订成功后再作取消的宾�?,将不予以作�??款处理�??<br>	"
			+ "&nbsp;4、请务必提供有效联系电话号码。如联络信息不准�?,不能提前与您确认准确的入住信�?,而�?�成在阁下入住时出现无房的情�?,酒店对此�?概不负责�?<br>	"
			+ "&nbsp;5、预订成功后如遇酒店推出其它优惠促销,恕不另行通知,也不能同时享受该优惠�?<br>"
			+ "&nbsp; 6、酒店房价会因房间销售状况变动时将有�?定幅度上�?,己成功预订的房间价格将不变动,具体房价可咨询酒店预订部�?<br>" + "&nbsp;7、套票内容及有效期等如有变动,恕不另行通知�?<br>"
			+ "&nbsp;8、如有任何异�?,请电话咨询酒店预订部�?<br>" + "<center><h3>购票须知</h3></center>"
			+ "&nbsp;* �?2016�?8�?15日起，取消持全国导游证的不带团导游免费入园优惠政策，现行的团队免司陪等规定不变�?? <br>" + "&nbsp;1、本须知适用于购买本网站的电子门票产品�??<br>"
			+ "&nbsp; 2、游客购买门票需指定游览日期，日期�?�择以购票页面可选日期为准！ <br>"
			+ "&nbsp;3、订单上的所有门票，须在指定游览日期的当天入园，过期无效。如�?订购多个公园门票但无法同�?天游玩完毕的，请注意分开日期订购。（套票中不设包含马戏剧院或横琴岛剧院表演类的儿童长者票，购票时请注意）�?<br>"
			+ "&nbsp;4、购票一经确认，即时成交,不可�?换�??<br>" + "&nbsp;5、相关票类说明：<br>" + "&nbsp;&nbsp;1)“全票�?�对象：指成人及身高1.5米以上儿童�??<br>"
			+ "&nbsp;&nbsp;2)“儿童长者票”对象：身高1.0米至1.5米以下儿童，�?65岁以上的长�?�凭身份证验票入园（马戏剧院或横琴岛剧院表演门票及另有规定的票类不�?�用）�??<br"
			+ ">&nbsp;注意:购买儿童长�?�票的游客，如儿童身高超过标准或长�?�游客入园时未能出示有效的身份证明文件，游客按入场当天的门市价补回差额或自行重新购票�?<br>"
			+ "&nbsp;&nbsp;3)“免票�?�对象：1.0米以下儿童（�?名购票成人限带一名免票儿童，马戏剧院或横琴岛剧院表演的门票及另有规定的票类不适用）�??<br>"
			+ "&nbsp;&nbsp;4)马戏剧院或横琴岛剧院表演门票的�?�全票�?�对象：�?有进入马戏剧院或横琴岛剧院表演场馆的观众均须购买全票。因表演时音效较为震撼，为保证游客安全及场内观看秩序，身�?1.0米以下儿童建议不入场观看，若坚持入场，则须购全票入场�?<br>"
			+ "&nbsp;&nbsp;5)关于两园套票的规定：<br>&nbsp;各公园套票（含酒店餐类套票）限同�?人在门票有效期日当天使用，游客进入第�?个公园须留存指纹，之后，凭门票及验证指纹进入第二个公园�??<br>"
			+ "&nbsp;&nbsp;①与马戏剧院或横琴岛剧院表演相关的两园套票须同一天游完；<br>"
			+ "&nbsp;&nbsp;②不含马戏剧院或横琴岛剧院表演的其它公园之间套票，游客可在门票有效期首日起分二日连续游完两公园（有特殊规定的两园套票除外，具体规定见购票页面说明文字），持票游客每个公园只可进出�?次；有效期首日当天，游客进入第一个公园，第二天可凭门票及验证指纹进入第二个公园；也可同一天游完两园�??<br>"
			+ "&nbsp;6)2016年公园票类特定日和平日定义：（特定日和平日门票价格不同，购票时请注意！）<br>"
			+ "&nbsp;&nbsp;①�?�特定日”指：元旦（1�?1�?-3日）、春节（2�?7�?-13日）、清明节 �?4�?2�?-4日）、五�?�?4�?30�?-5�?2日）、端午节�?6�?9�?-11日）、中秋节�?9�?15�?-17日）、国庆节�?10�?1�?-7日）等国家规定的假期及暑�? �?7�?1�?-8�?31日）及所有周末（周六、日）；如国家法定假日具体日期有变动再行调整�?<br>"
			+ "&nbsp;&nbsp;②平日指：除上述特定日子之外的日期�??<br>" + "&nbsp;&nbsp;③特殊票类（如酒店自助餐等）的特定日期另有规定，具体见订票页面说明�??<br>"
			+ "&nbsp;6、订单查询： <br>"
			+ "&nbsp;&nbsp;在门票有效期内，游客可以在本网站“订单查询�?�上输入“订票手机号”和游客自己预留的�?�查询密码�?�查询在长隆官网已订购电子门票的订单情况及取票凭证码等信息，也可按规定进行改期操作（微信支付订票除外）�??<br>"
			+ "&nbsp;7、取票方式（选其�?）：<br>" + "&nbsp;&nbsp;1)成功订票后可凭�?�取票凭证码”及订票手机号尾4位数到景区换取正式门票； <br>"
			+ "&nbsp;&nbsp;2)按收到的购票短信链接地址在线下载“二维码门票”并截图保留，入园时扫描验证该二维码门票即可，无�?再换取纸质门票；<br>"
			+ "&nbsp;&nbsp;3)景区现场当天�?迟取票截止时间为:公园或剧院闭园前二小时�??<br>" + "&nbsp;8、购票后如遇园区推出优惠促销，恕不另行�?�知，也不能享受该优惠�??<br>"
			+ "&nbsp;9、购票信息请注意保密，因游客个人原因泄露该信息�?��?�成的损失由游客自行承担�?<br>"
			+ "&nbsp;10、香港及国内公众假期期间或根据市场需求，马戏剧院或横琴岛剧院表演可能加场演出，如有变动，以本网站订票页面可�?�的场次时间或景区现场公告为准�??<br> "
			+ "&nbsp;11、进入长隆各主题公园，观众必须接受安全检查，严禁携带管制器具、枪支弹药�?�易燃易爆物品�?�食品�?�饮料等物品入园�?<br>"
			+ "&nbsp;12、游玩前请参阅相应主题公园的�?放时间�?�表演时间及注意事项�?<br>" + "&nbsp;13、游客在本网站购票视为允许本网站将有关订票信息以短信或彩信方式发送至订票手机上�??<br>"
			+ "&nbsp;14、关于发票：如需另开发票的，请在门票原有效期日一个月内凭门票公园售票处开具发票，过期及已�?过发票的不再办理�?票�??<br>"
			+ "&nbsp;15、长隆集团全国客服热线：4008-830083(用户拨打免国内长途话�?,不免市内话费)�?<br>";

	public static final String SCENIC_RESCHEDULED = "1.每个门票取票码对应的门票改期操作只允许一�? ，一经改期不允许再次修改�?<br>2.改期的门票订单，只允许在订单有效期内修改�?<br>3.改期门票的日票价须与原游玩日期票价一致时才允许改期�??<br>4.珠海马戏门票和自助餐不允许改期�??<br>5.酒店暂不允许改期�?<br>6.门票改期只能选择从当前日期起30天内的日期�?�如：当前日期为2016�?7�?1日，改期日期�?多只能�?�择�?2016�?7�?30日�??<br>7.门票改期不允许修改当天日期�??<br>";

	public static final String IS_FIRST_OPEN = "is_first_open_for_";

	public static final String HOTLINE_DATA = "hotline_data_";

	public static final String PERFORMANCE_FOR_TYPE = "performance_";

	public static final String MARKET_CHANNEL_FOR_CHIMELONG = "chimelong";

	public static final String MARKET_CHANNEL_FOR_360 = "360";

	public static final String MARKET_CHANNEL_FOR_TENCENT = "tencent";

	public static final String MARKET_CHANNEL_FOR_HUAWEI = "huawei";

	public static final String MARKET_CHANNEL_FOR_XIAOMI = "xiaomi";

	public static final String MARKET_CHANNEL_FOR_BAIDU = "baidu";

	public static final String CUSTOMER_SERVICE_DATA = "customer_service_data_";

	public static final String COOKIE_LAB = "cookie_lab_uid_" + REQUEST_V_VALUE + "_";

	public static final String WAP_COOKIE_LAB = "USER_CN_COOKIE_SESSIONID_" + REQUEST_ORG_ID_VALUE;

	public static final String AD_ALERT_LAB = "ad_alert_" + REQUEST_ORG_ID_VALUE;

	public static final String AD_INDEX_LAB = "ad_index_" + REQUEST_ORG_ID_VALUE;

	public static final String FEEDBACK_WAP_URL = "feedback_wap_url_" + REQUEST_ORG_ID_VALUE;

	public static final String IS_SHOW_MEMBER = "is_member_show";

	public static final String WAP_COOKIE_KEY_LAB = "USER_CN_COOKIE_SESSIONID_" + REQUEST_ORG_ID_VALUE;

	public static final String JPUSH_MSG_ACTION = "jpush.msg.action";

	public static final String DIALOG_WAIT_MSG = "请稍�?";

	public static final String APK_DOWNLOAD_URL = "apk_url";

	public static final String DOWNLOAD_APK_NAME = "apk_name";

	public static final String COUNTRY_JSON = "[{\"country_code\":\"86\",\"chinese_name\":\"中国\",\"global_name\":\"China\",\"short_name\":\"CN\",\"pattern\":\"^(86){0,1}1[34578][0-9]{9}$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/zg.jpg\",\"example\":\"8613123456789\",\"enabled\":1},{\"country_code\":\"852\",\"chinese_name\":\"香港\",\"global_name\":\"Hong Kong\",\"short_name\":\"HK\",\"pattern\":\"^(00){0,1}(852){1}0{0,1}[1,5,6,9](?:\\\\d{7}|\\\\d{8}|\\\\d{12})$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/xg.jpg\",\"example\":\"85251234567\",\"enabled\":1},{\"country_code\":\"853\",\"chinese_name\":\"澳门\",\"global_name\":\"Macau\",\"short_name\":\"MO\",\"pattern\":\"^(00){0,1}(853){1}6\\\\d{7}$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/am.jpg\",\"example\":\"85366123456\",\"enabled\":1},{\"country_code\":\"886\",\"chinese_name\":\"台湾\",\"global_name\":\"Taiwan\",\"short_name\":\"TW\",\"pattern\":\"^(00){0,1}(886){1}0{0,1}[6,7,9](?:\\\\d{7}|\\\\d{8}|\\\\d{10})$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/tw.jpg\",\"example\":\"886912345678\",\"enabled\":1},{\"country_code\":\"82\",\"chinese_name\":\"韩国\",\"global_name\":\"South Korea\",\"short_name\":\"KR\",\"pattern\":\"^(00){0,1}(82){1}0{0,1}[7,1](?:\\\\d{8}|\\\\d{9})$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/hg.jpg\",\"example\":\"821023456789\",\"enabled\":1},{\"country_code\":\"81\",\"chinese_name\":\"日本\",\"global_name\":\"Japan\",\"short_name\":\"JP\",\"pattern\":\"^(00){0,1}(81){1}0{0,1}[7,8,9](?:\\\\d{8}|\\\\d{9})$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/rb.jpg\",\"example\":\"817012345678\",\"enabled\":1},{\"country_code\":\"65\",\"chinese_name\":\"新加坡\",\"global_name\":\"Singapore\",\"short_name\":\"SG\",\"pattern\":\"^(00){0,1}(65){1}[13689]\\\\d{6,7}$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/xjp.jpg\",\"example\":\"658XXXXXXX\",\"enabled\":1},{\"country_code\":\"60\",\"chinese_name\":\"马来西亚\",\"global_name\":\"Malaysia\",\"short_name\":\"MY\",\"pattern\":\"^(00){0,1}(60){1}1\\\\d{8,9}$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/mlxy.jpg\",\"example\":\"60123456789\",\"enabled\":1},{\"country_code\":\"66\",\"chinese_name\":\"泰国\",\"global_name\":\"Thailand\",\"short_name\":\"TH\",\"pattern\":\"^(00){0,1}(66){1}[13456789]\\\\d{7,8}\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/tg.jpg\",\"example\":\"668X XXX XXXX\",\"enabled\":1},{\"country_code\":\"84\",\"chinese_name\":\"越南\",\"global_name\":\"Vietnam\",\"short_name\":\"VN\",\"pattern\":\"^(00){0,1}(84){1}[1-9]\\\\d{6,9}$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/yn.jpg\",\"example\":\"84912345678\",\"enabled\":1},{\"country_code\":\"91\",\"chinese_name\":\"印度\",\"global_name\":\"India\",\"short_name\":\"IN\",\"pattern\":\"^(00){0,1}(91){1}\\\\d{6,12}$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/yd.jpg\",\"example\":\"919XXXXXXXXX\",\"enabled\":1},{\"country_code\":\"90\",\"chinese_name\":\"土�?�其\",\"global_name\":\"Turkey\",\"short_name\":\"TR\",\"pattern\":\"^(00){0,1}(90){1}\\\\d{6,12}$\",\"icon\":\"http://static.inner.evente.cn:30315/evente/img/flag/v1/teq.jpg\",\"example\":\"905012345678\",\"enabled\":1}]";

	public static final String COUNTRY_LAB = "country_lab";

	public static final String SHARE_TITLE_LAB = "share_title";

	public static final String SHARE_CONTENT_LAB = "share_content";

	public static final String SHARE_IMG_URL_LAB = "share_img_url";

	public static final String SHARE_URL_LAB = "share_url";
	// 排序常量
	public static final String HOTEL_PRODUCT_ORDER_SORT = "1";
	public static final String SCENIC_PRODUCT_ORDER_SORT = "2";
	public static final String GOODS_PRODUCT_ORDER_SORT = "3";
	public static final String EVENT_PRODUCT_ORDER_SORT = "4";

}
