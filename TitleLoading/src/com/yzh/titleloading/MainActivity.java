package com.yzh.titleloading;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yzh.titleloading.util.Net;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		sendOrderedBroadcast(new Intent(Net.StartNet), null);
		String url = "http://www.androidsnippets.com/open-any-file-using-default-app-even-without-knowing-the-mime-type2";
		Net.post(this, url, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				Log.i("youzh", new String(arg2));
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
			}
			
			@Override
			public void onFinish() {
				super.onFinish();
				sendOrderedBroadcast(new Intent(Net.EndNet), null);
			}
		});
	}

}
