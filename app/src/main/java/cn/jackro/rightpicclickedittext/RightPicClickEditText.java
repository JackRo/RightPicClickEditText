package cn.jackro.rightpicclickedittext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * 实现右侧图标点击事件监听的EditText
 */
public class RightPicClickEditText extends AppCompatEditText {

    /**
     * EditText右侧的图标
     */
    private Drawable mRightDrawable;

    private OnRightPicClickListener onRightPicClickListener;

    public RightPicClickEditText(Context context) {
        super(context);
        init();
    }

    public RightPicClickEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RightPicClickEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRightDrawable = getCompoundDrawables()[2];

        if (mRightDrawable == null) {
            return;
        }

        mRightDrawable.setBounds(0, 0, mRightDrawable.getIntrinsicWidth(), mRightDrawable.getIntrinsicHeight());
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (mRightDrawable != null) {
                boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight())
                        && (event.getX() < ((getWidth() - getPaddingRight())));
                if (touchable) {

                    //设置点击EditText右侧图标EditText失去焦点，
                    // 防止点击EditText右侧图标EditText获得焦点，软键盘弹出
                    setFocusableInTouchMode(false);
                    setFocusable(false);

                    //点击EditText右侧图标事件接口回调
                    if (onRightPicClickListener != null) {
                        onRightPicClickListener.rightPicClick(this);
                    }
                } else {
                    //设置点击EditText输入区域，EditText请求焦点，软键盘弹出，EditText可编辑
                    //setFocusableInTouchMode(true);
                    //setFocusable(true);
                    //设置点击EditText输入区域，EditText不请求焦点，软键盘不弹出，EditText不可编辑
                    setFocusableInTouchMode(false);
                    setFocusable(false);
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public void setOnRightPicClickListener(OnRightPicClickListener onRightPicClickListener) {
        this.onRightPicClickListener = onRightPicClickListener;
    }

    public interface OnRightPicClickListener {
        void rightPicClick(EditText editText);
    }
}
