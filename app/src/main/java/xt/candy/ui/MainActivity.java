package xt.candy.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import okhttp3.Call;
import xt.candy.R;
import xt.candy.Utils.TipsUtils;
import xt.candy.base.BaseActivity;
import xt.candy.base.BusStringCallback;
import xt.candy.Utils.NetUtil;
import xt.candy.model.LineMsgModel;
import xt.candy.model.ModelManger;

import java.util.TreeMap;

public class MainActivity extends BaseActivity {

    private EditText mEtInput;
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

        if (!TextUtils.isEmpty(lineName)) {
            TreeMap params  = new TreeMap();
            params.put("name",  checLineName(lineName));
             NetUtil.doGet(NetUtil.LINE_MSG, params, new BusStringCallback() {
                 @Override
                 public void onBusResponse(String response, int id) {
                     LineMsgModel model = ModelManger.getModel(response, LineMsgModel.class);
                     if(null == model){
                         TipsUtils.showSnackBar(rootView,"请输入正确的线路");
                     }else{
                         getStopMsg(model);

                     }
                 }

             });
        }
    }


    //手动添加路
    @NonNull
    private String checLineName(String lineName) {
        if(TextUtils.isEmpty(lineName)){
            return "";
        }
        if (!lineName.contains("路")) {
            lineName += "路";
        }
        return lineName;
    }

    private void getStopMsg(LineMsgModel model) {
        TreeMap params  = new TreeMap();
        params.put("name",checLineName(model.line_name));
        params.put("lineid",model.line_id);
        NetUtil.doGet(  NetUtil.STOP_MSG, NetUtil.getStopMsgHeader(), params,new BusStringCallback(){

            @Override
            public void onBusResponse(String response, int id) {

            }


        });
    }
}
