package team.birdhead.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import team.birdhead.aspectratioimageview.R;

public class AspectRatioImageView extends ImageView {

    public static final int FIXED_WIDTH = 0;
    public static final int FIXED_HEIGHT = 1;

    private float mAspectRatio;
    private int mFixed;

    public AspectRatioImageView(Context context) {
        super(context);

        initialize(context, null, 0, 0);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initialize(context, attrs, 0, 0);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initialize(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initialize(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView, defStyleAttr, defStyleRes);
        try {
            setAspectRatio(a.getFloat(R.styleable.AspectRatioImageView_aspectRatio, 0));
            setFixed(a.getInt(R.styleable.AspectRatioImageView_fixed, FIXED_WIDTH));
        } finally {
            a.recycle();
        }
    }

    public void setAspectRatio(float aspectRatio) {
        if (mAspectRatio != aspectRatio) {
            mAspectRatio = aspectRatio;
            requestLayout();
        }
    }

    public void setFixed(int fixed) {
        if (fixed != FIXED_WIDTH && fixed != FIXED_HEIGHT) {
            throw new IllegalArgumentException(String.format("invalid fixed=%d", fixed));
        }

        if (mFixed != fixed) {
            mFixed = fixed;
            requestLayout();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mAspectRatio <= 0) {
            return;
        }

        int width;
        int height;
        if (mFixed == FIXED_WIDTH) {
            width = getMeasuredWidth();
            height = (int) (width * mAspectRatio);
        } else {
            height = getMeasuredHeight();
            width = (int) (height / mAspectRatio);
        }

        setMeasuredDimension(width, height);
    }
}
