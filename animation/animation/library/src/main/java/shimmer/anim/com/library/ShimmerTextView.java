package shimmer.anim.com.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Yuriy on 2016/11/16.
 */
public class ShimmerTextView extends TextView {

    private static final String TAG = "ShimmerTextView--doni";

    private float gradient;
    private int primaryColor;
    // shimmer reflection color
    private int reflectionColor;

    private Paint paint;
    private LinearGradient linearGradient;
    private Matrix linearGradientMatrix;

    /***************************************/
    public ShimmerTextView(Context context) {
        super(context);
        Log.i(TAG, "ShimmerTextView000");
    }

    public ShimmerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "ShimmerTextView111");
        primaryColor = getCurrentTextColor();
        paint = getPaint();
        init(attrs);
    }


    public ShimmerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(TAG, "ShimmerTextView222");
        primaryColor = getCurrentTextColor();
        paint = getPaint();
        init(attrs);
    }


    /****************新增的方法************************/
    private void init(AttributeSet attributeSet) {
        reflectionColor = 0xFFFFFFFF;
        if (attributeSet != null) {
            TypedArray a = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ShimmerView, 0, 0);
            if (a != null) {
                try {
                    reflectionColor = a.getColor(R.styleable.ShimmerView_reflectionColor, 0xFFFF0000);
                } catch (Exception e) {
                    android.util.Log.e("ShimmerTextView", "Error while creating the view:", e);
                } finally {
                    a.recycle();
                }
            }
        }

        linearGradientMatrix = new Matrix();
    }

    private void resetLinearGradient() {

        // our gradient is a simple linear gradient from textColor to reflectionColor. its axis is at the center
        // when it's outside of the view, the outer color (textColor) will be repeated (Shader.TileMode.CLAMP)
        // initially, the linear gradient is positioned on the left side of the view
        linearGradient = new LinearGradient(-this.getWidth(), 0, 0, 0,
                new int[]{
                        primaryColor,
                        reflectionColor,
                        primaryColor,
                },
                new float[]{
                        0,
                        0.5f,
                        1
                },
                Shader.TileMode.CLAMP
        );

        paint.setShader(linearGradient);
    }


     void setGradientX(float gradient){

         Log.i(TAG,"setgradientX"+gradient);
         this.gradient = gradient;
         this.invalidate();
    }

    /*****************************************/

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i(TAG,"onSizeChanged");
        super.onSizeChanged(w, h, oldw, oldh);
        resetLinearGradient();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(TAG,"onDraw");
            // first onDraw() when shimmering
            if (paint.getShader() == null) {
                paint.setShader(linearGradient);
            }

            // translate the shader local matrix
            linearGradientMatrix.setTranslate(2 * gradient, 0);

            // this is required in order to invalidate the shader's position
            linearGradient.setLocalMatrix(linearGradientMatrix);


        super.onDraw(canvas);
    }
}
