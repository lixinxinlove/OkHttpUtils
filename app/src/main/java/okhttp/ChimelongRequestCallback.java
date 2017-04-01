package okhttp;

import okhttp3.Call;

public abstract class ChimelongRequestCallback {

	private Call mCall;

	/**
	 * 请求结果回调
	 * 
	 * @param res
	 */
	public abstract void _RequestCallback(ChimelongResponseEntity res);

	/**
	 * 请求取消
	 */
	public void _onCancelled() {
		if (mCall != null) {
			mCall.cancel();
		}
	};

	/**
	 * 请求加载�?
	 * 
	 * @param total
	 * @param current
	 * @param isUploading
	 */
	public void _onLoading(long total, long current, boolean isUploading) {

	};

	/**
	 * 请求�?�?
	 */
	public void _onStart() {
	}

	public Call getmCall() {
		return mCall;
	}

	public void setmCall(Call mCall) {
		this.mCall = mCall;
	}

}
