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
public class LineMsgView extends LinearLayout {
    public LineMsgView(Context context) {
        this(context, null);
    }

    public LineMsgView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineMsgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private TextView tvLeft;
    private TextView tvRight;
    private ImageView ivSelect;

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.view_linemsg, this, true);
        tvLeft = (TextView) layout.findViewById(R.id.tv_left);
        tvRight = (TextView) layout.findViewById(R.id.tv_right);
        ivSelect = (ImageView) layout.findViewById(R.id.iv_selelct);
    }

    public TextView getTvLeft() {
        return tvLeft;
    }

    public TextView getTvRight() {
        return tvRight;
    }

    public void  setLeftText(String text){
        tvLeft.setText(text);
    }

    public void  setRightText(String text){
        tvRight.setText(text);
    }

    public void setSeleclt(boolean isSelect){
        if(isSelect){
            ivSelect.setVisibility(VISIBLE);
        }else {
            ivSelect.setVisibility(INVISIBLE);
        }
    }

    public boolean getSeleectStatus(){
      return  VISIBLE == ivSelect.getVisibility();
    }
}
