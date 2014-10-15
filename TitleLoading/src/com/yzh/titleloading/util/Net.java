package com.yzh.titleloading.util;

import android.content.Context;
import android.content.Intent;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class Net {

	public static String EndNet = Net.class.getName() + ".ENDNET";
	public static String StartNet = Net.class.getName() + ".STARTNET";

	public static final int NetTimeout = 30000;
	protected static AsyncHttpClient client;

	static {
		client = new AsyncHttpClient();
		client.setTimeout(NetTimeout);
	}
	
	public static void post(Context ctx, String url, AsyncHttpResponseHandler responseHandler) {
		client.post(url, responseHandler);
	}
}
