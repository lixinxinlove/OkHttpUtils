package okhttp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.lee.glidedemo.R;

public class MainActivity extends ActionBarActivity {

	private Button mBtn;

	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		mBtn = (Button) findViewById(R.id.go_click);
		text = (TextView) findViewById(R.id.text);
		mBtn.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			DataApiForOkHttp http = new DataApiForOkHttp();
			http.get(callback);
		}

	};

	private ChimelongRequestCallback callback = new ChimelongRequestCallback() {

		@Override
		public void _RequestCallback(final ChimelongResponseEntity res) {
			text.setText(res.code + ":" + res.data);
		}

		@Override
		public void _onStart() {
			super._onStart();
			text.setText("开始");
		}

	};

	protected void onStop() {
		super.onStop();
		callback._onCancelled();
	};

}
