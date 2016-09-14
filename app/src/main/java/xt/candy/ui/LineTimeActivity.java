package xt.candy.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.TreeMap;

import xt.candy.R;
import xt.candy.Utils.BusUtils;
import xt.candy.base.BaseActivity;
import xt.candy.base.BusStringCallback;
import xt.candy.model.LineMsgModel;
import xt.candy.net.NetUtil;
import xt.candy.view.TopView;

//时刻查询
public class LineTimeActivity extends BaseActivity {
    public final static String INTENTKEY = "intentKey";
    public final String NAME = "name";
    public final String LINEID = "lineid";
    private TopView mTopView;
    private LineMsgModel model;

    public static void showActivity(LineMsgModel model, Activity activity) {
        Intent intent = new Intent(activity, LineTimeActivity.class);
        intent.putExtra(INTENTKEY, model);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_time);
        initView();
        initData();
    }

    private void initView() {
        mTopView = (TopView) findViewById(R.id.topview);
    }

    private void initData() {
        Intent intent = getIntent();
        model = intent.getParcelableExtra(INTENTKEY);

        mTopView.setTitle(BusUtils.checLineName(model.line_name));
        TreeMap params = new TreeMap();
        params.put(NAME, BusUtils.checLineName(model.line_name));
        params.put(LINEID, model.line_id);
        NetUtil.doGet(NetUtil.STOP_MSG, NetUtil.getStopMsgHeader(), params, new BusStringCallback() {
            @Override
            public void onBusResponse(String response, int id) {

            }
        });
    }
}
