package xt.candy.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import okhttp3.Call;
import xt.candy.R;
import xt.candy.Utils.ToastUtils;
import xt.candy.base.BaseActivity;
import xt.candy.base.BusStringCallback;
import xt.candy.Utils.NetUtil;

import java.util.TreeMap;

public class MainActivity extends BaseActivity {

    private EditText mEtInput;
    private TreeMap params  = new TreeMap();;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        params.clear();
        if (!TextUtils.isEmpty(lineName)) {
            //手动添加路
            if (!lineName.contains("路")) {
                lineName += "路";
            }

            params.put("name", lineName);
             NetUtil.doGet(NetUtil.LINE_MSG, params, new BusStringCallback() {

                 @Override
                 public void onBusResponse(String response, int id) {
                     getStopMsg("003730");
                     ToastUtils.showToast(rootView,"请输入正确的线路");
                 }

                 @Override
                 public void onBusError(Call call, Exception e, int id) {
                     ToastUtils.showToast(rootView,"请输入正确的线路");
                 }
             });
        }
    }

    private void getStopMsg(String lineID) {
        params.put("lineid",lineID);
        NetUtil.doGet(  NetUtil.STOP_MSG, NetUtil.getStopMsgHeader(), params,new BusStringCallback(){

            @Override
            public void onBusResponse(String response, int id) {

            }

            @Override
            public void onBusError(Call call, Exception e, int id) {

            }
        });
    }
}
