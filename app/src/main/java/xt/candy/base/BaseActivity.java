package xt.candy.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.wang.avi.AVLoadingIndicatorView;

import xt.candy.R;

/**
 * Created by Administrator on 2016/9/13.
 */
public class BaseActivity extends AppCompatActivity {

    public AVLoadingIndicatorView loadingView;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        FrameLayout rootView = (FrameLayout) View.inflate(this, R.layout.activity_base, null);
        View childeView = View.inflate(this, layoutResID, null);
        rootView.addView(childeView,0);

        loadingView = (AVLoadingIndicatorView) rootView.findViewById(R.id.avi);
        loadingView.setIndicator("BallClipRotatePulseIndicator");
        super.setContentView(rootView);
    }



    public void showLoadingView(){
        loadingView.setVisibility(View.VISIBLE);
    }

    public void hideLoadingView(){
        loadingView.setVisibility(View.GONE);
    }
}
