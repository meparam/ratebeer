package com.ratebeer.android.gui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public final class Animations {

	public static void fadeFlip(final View in, final View out) {
		ObjectAnimator animOut = ObjectAnimator.ofFloat(out, "alpha", 1F, 0F);
		ObjectAnimator animIn = ObjectAnimator.ofFloat(in, "alpha", 0F, 1F);
		in.setAlpha(0F);
		in.setVisibility(View.VISIBLE);
		in.setTag(View.VISIBLE);
		out.setTag(View.INVISIBLE);
		AnimatorSet animSetXY = new AnimatorSet();
		animSetXY.playTogether(animOut, animIn);
		animSetXY.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				//noinspection WrongConstant
				out.setVisibility((Integer) out.getTag());
			}
		});
		animSetXY.start();
	}

	public static void fadeFlip(final View in, final View out1, final View out2) {
		ObjectAnimator animOut1 = ObjectAnimator.ofFloat(out1, "alpha", 1F, 0F);
		ObjectAnimator animOut2 = ObjectAnimator.ofFloat(out2, "alpha", 1F, 0F);
		ObjectAnimator animIn = ObjectAnimator.ofFloat(in, "alpha", 0F, 1F);
		in.setAlpha(0F);
		in.setVisibility(View.VISIBLE);
		in.setTag(View.VISIBLE);
		out1.setTag(View.INVISIBLE);
		out2.setTag(View.INVISIBLE);
		AnimatorSet animSetXY = new AnimatorSet();
		animSetXY.playTogether(animOut1, animOut2, animIn);
		animSetXY.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				//noinspection WrongConstant
				out1.setVisibility((Integer) out1.getTag());
				//noinspection WrongConstant
				out2.setVisibility((Integer) out2.getTag());
			}
		});
		animSetXY.start();
	}

}
