package xt.candy.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import xt.candy.R;
import xt.candy.Utils.BusUtils;
import xt.candy.Utils.TipsUtils;
import xt.candy.base.BaseActivity;
import xt.candy.base.BusStringCallback;
import xt.candy.net.NetUtil;
import xt.candy.model.LineMsgModel;
import xt.candy.model.ModelManger;
import xt.candy.view.TopView;

import java.util.TreeMap;

public class MainActivity extends BaseActivity {

    private EditText mEtInput;
    private View rootView;
    private TopView mTopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTopView = (TopView) findViewById(R.id.topview);
        mTopView.getIvLeft().setVisibility(View.INVISIBLE);
        mTopView.setTitle("公交准点查询");
        rootView = findViewById(R.id.root_view);
        mEtInput = (EditText) findViewById(R.id.et_input);
        findViewById(R.id.tv_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSearch();
            }
        });

    }

    //开始搜索
    private void doSearch() {
        String lineName = mEtInput.getText().toString();

        if (!TextUtils.isEmpty(lineName)) {
            TreeMap params  = new TreeMap();
            params.put("name",  BusUtils.checLineName(lineName));
             NetUtil.doGet(NetUtil.LINE_MSG, params, new BusStringCallback() {
                 @Override
                 public void onBusResponse(String response, int id) {
                     LineMsgModel model = ModelManger.getModel(response, LineMsgModel.class);
                     if(null == model){
                         TipsUtils.showSnackBar(rootView,"请输入正确的线路");
                     }else{
                         LineTimeActivity.showActivity(model,MainActivity.this);
                     }
                 }

             });
        }
    }

}
