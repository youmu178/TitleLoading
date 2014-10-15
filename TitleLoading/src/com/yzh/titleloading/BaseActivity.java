package com.yzh.titleloading;


import com.yzh.titleloading.ui.TitleLayout;
import com.yzh.titleloading.util.Net;
import com.yzh.titleloading.util.NetworkEventReceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class BaseActivity extends Activity {

	private TitleLayout tl = null;
	private boolean tlflg = true;
	
	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if(action.equals(Net.StartNet)) {
				if(NetworkEventReceiver.NetCount > 0) {
					if(tl == null && tlflg) {
						tl = (TitleLayout) BaseActivity.this.findViewById(R.id.titleLayout);
						tlflg = false;
					}
					if(tl != null) {
						tl.start();
					}
				}
			} else if(action.equals(Net.EndNet)) {
				if(NetworkEventReceiver.NetCount <= 0) {
					if(tl != null) {
						tl.stop();
					}
				}
			}
		}
	};
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        IntentFilter filter = new IntentFilter();
        filter.setPriority(100);
		filter.addAction(Net.EndNet);
		filter.addAction(Net.StartNet);
		registerReceiver(mBroadcastReceiver, filter);
    }
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus) {
			if(NetworkEventReceiver.NetCount > 0) {
				if(tl == null && tlflg) {
					tl = (TitleLayout) BaseActivity.this.findViewById(R.id.titleLayout);
					tlflg = false;
				}
				if(tl != null) {
					tl.start();
				}
			}
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mBroadcastReceiver);
	}
}
