package shimmer.anim.com.library;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Yuriy on 2016/11/17.
 */
public class Shimmer {

    private ObjectAnimator animator;

    public <V extends View>void start(final V shimmerview) {


        final Runnable anim = new Runnable() {
            @Override
            public void run() {
                 float fromX = 0;
                 float toX = shimmerview.getWidth();

                animator = ObjectAnimator.ofFloat(shimmerview, "gradientX", fromX, toX);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.setDuration(2000);
                animator.setStartDelay(0);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                animator.start();
            }
        };
        anim.run();
    }
}
