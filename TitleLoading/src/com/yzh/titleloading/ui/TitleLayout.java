package com.yzh.titleloading.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TitleLayout extends RelativeLayout {
	private MarqueeBallView mbw;
	
	public TitleLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TitleLayout(Context context) {
		super(context);
	}
	
	public void start() {
		if(mbw == null) {
			mbw = new MarqueeBallView(this.getContext());
			ViewGroup.LayoutParams lp2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getHeight());
			mbw.setVisibility(View.GONE);
			addView(mbw, 0, lp2);
			mbw.setAnimationWidth(getWidth());
		}
		mbw.start();
	}

	public void stop() {
		if(mbw != null) {
			mbw.stop();
		}
	}
}
