package okhttp;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataApiForOkHttp {

	public OkHttpClient http;

	private static final String GET_METHOD = "GET";
	private static final String POST_METHOD = "POST";

	private Handler mHandler = new Handler(Looper.getMainLooper());

	public DataApiForOkHttp() {

		http = new OkHttpClient();
	}

	public void get(ChimelongRequestCallback callback) {
		Request.Builder requestBuilder = new Request.Builder().url("http://www.baidu.com");
		requestBuilder.method(GET_METHOD, null);
		Request request = requestBuilder.build();
		Call mcall = http.newCall(request);
		callback.setmCall(mcall);
		mcall.enqueue(new ChimelongRequestCallbackImpl(callback));
	}

	public void post(ChimelongRequestCallback callback,FormBody body,String url) {
		Request.Builder requestBuilder = new Request.Builder().url("http://www.baidu.com");
		Builder builder = new Builder();
		//FormBody body = builder.add("", "").build();
		requestBuilder.post(body).build();
		Request request = requestBuilder.post(body).build();
		Call mcall = http.newCall(request);
		mcall.enqueue(new ChimelongRequestCallbackImpl(callback));
	}

	public class ChimelongRequestCallbackImpl implements Callback {

		private ChimelongRequestCallback mCallback;

		private ChimelongResponseEntity resEntity = new ChimelongResponseEntity();

		public ChimelongRequestCallbackImpl(ChimelongRequestCallback callback) {
			this.mCallback = callback;
			mHandler.post(new Runnable() {

				@Override
				public void run() {
					mCallback._onStart();
				}
			});
		}

		@Override
		public void onFailure(Call arg0, IOException arg1) {
			resEntity.code = ChimelongConfig.HTTP_REQUEST_FAILURE;
			resEntity.message = "网络异常";
			mHandler.post(new Runnable() {

				@Override
				public void run() {
					mCallback._RequestCallback(resEntity);
				}
			});
		}

		@Override
		public void onResponse(Call arg0, Response response) throws IOException {
			if (response.isSuccessful()) {
				String res = response.body().string();
				try {
					resEntity = GsonUtils.asJSONToResponseEntity(res);
					mHandler.post(new Runnable() {

						@Override
						public void run() {
							mCallback._RequestCallback(resEntity);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
					resEntity.code = ChimelongConfig.HTTP_REQUEST_JSON_ERROR;
					resEntity.message = "数据格式错误";
					resEntity.data = res;
					mHandler.post(new Runnable() {

						@Override
						public void run() {
							mCallback._RequestCallback(resEntity);
						}
					});
				}
			}
		}
	}
}
