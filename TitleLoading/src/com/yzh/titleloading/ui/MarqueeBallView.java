package com.yzh.titleloading.ui;

import com.yzh.titleloading.R;

import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MarqueeBallView extends ImageView {
	private Animation anim;
	private boolean isStart = false;
	private int width;

	public MarqueeBallView(Context context) {
		super(context);
		setBackgroundResource(R.drawable.scan);
	}
	
	public void setAnimationWidth(int w) {
		width = w;
	}
	
	public void start() {
		if(isStart == false) {
			bringToFront();
			clearAnimation();
			setVisibility(MarqueeBallView.VISIBLE);
			this.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
			int thisw = this.getMeasuredWidth();
			anim = new TranslateAnimation(-thisw, width+thisw, 0, 0);
			anim.setDuration(600);
			anim.setInterpolator(new AccelerateInterpolator());
			anim.setRepeatCount(Animation.INFINITE);
			anim.setRepeatMode(Animation.RESTART);
			anim.setAnimationListener(null);
			startAnimation(anim);
			
			isStart = true;
		}
	}

	public void stop() {
		if(isStart == true) {
			anim.setAnimationListener(new AnimationListener() {
				public void onAnimationStart(Animation animation) {
				}
				public void onAnimationEnd(Animation animation) {
				}
				public void onAnimationRepeat(Animation animation) {
					MarqueeBallView.this.clearAnimation();
					MarqueeBallView.this.setVisibility(MarqueeBallView.INVISIBLE);
					isStart = false;
				}
			});
		}
	}
}
