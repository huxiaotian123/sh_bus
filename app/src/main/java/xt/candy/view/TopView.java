package xt.candy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import xt.candy.R;
import xt.candy.base.BaseActivity;

/**
 * 项目名称：sh_bus
 * 类描述：
 * 创建时间：2016/9/14 13:06
 */
public class TopView extends LinearLayout {
    public TopView(Context context) {
        this(context, null);
    }

    public TopView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private ImageView ivLeft;
    private TextView tvTitle;
    private ImageView ivRight;

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.topview, this, true);
        ivLeft = (ImageView) layout.findViewById(R.id.iv_back);
        tvTitle = (TextView) layout.findViewById(R.id.tv_title);
        ivRight = (ImageView) layout.findViewById(R.id.iv_confirm);

        if (context instanceof BaseActivity) {
            final BaseActivity activity = (BaseActivity) context;
            ivLeft.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }


    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public ImageView getIvLeft() {
        return ivLeft;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public ImageView getIvRight() {
        return ivRight;
    }
}
