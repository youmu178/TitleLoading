package com.yzh.titleloading.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkEventReceiver extends BroadcastReceiver{
	public static int NetCount = 0;
	
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if(action.equals(Net.StartNet)) {
			NetCount ++;
		} else if(action.equals(Net.EndNet)) {
			NetCount --;
		}
	}
}
