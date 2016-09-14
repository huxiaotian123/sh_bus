package xt.candy.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.TreeMap;

import okhttp3.Call;
import xt.candy.R;
import xt.candy.Utils.BusUtils;
import xt.candy.Utils.TipsUtils;
import xt.candy.base.BaseActivity;
import xt.candy.base.BusStringCallback;
import xt.candy.base.HxtListAdapter;
import xt.candy.base.HxtListHolder;
import xt.candy.model.BusTimeModel;
import xt.candy.model.LineMsgModel;
import xt.candy.model.ModelManger;
import xt.candy.model.StopMsgModel;
import xt.candy.net.NetUtil;
import xt.candy.view.LineMsgView;
import xt.candy.view.TopView;

//时刻查询
public class LineTimeActivity extends BaseActivity {
    public final static String INTENTKEY = "intentKey";
    public final String NAME = "name";
    public final String LINEID = "lineid";
    private TopView mTopView;
    private LineMsgModel model;
    private View rootView;
    private LineMsgView mLineMsgView0;
    private LineMsgView mLineMsgView1;
    private ListView mListview;
    private LineTimeAdapter mAdapter;
    private TreeMap params;
    private String direction = "0";
    public static void showActivity(LineMsgModel model, Activity activity) {
        Intent intent = new Intent(activity, LineTimeActivity.class);
        intent.putExtra(INTENTKEY, model);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_time);
        showLoadingView();
        initView();
        initData();
    }

    private void initView() {
        rootView = findViewById(R.id.root_view);
        mTopView = (TopView) findViewById(R.id.topview);
        mLineMsgView0 = (LineMsgView) findViewById(R.id.line0);
        mLineMsgView1 = (LineMsgView) findViewById(R.id.line1);
        mListview = (ListView) findViewById(R.id.select_dialog_listview);
    }

    private void initData() {
        Intent intent = getIntent();
        model = intent.getParcelableExtra(INTENTKEY);

        mTopView.setTitle(BusUtils.checLineName(model.line_name));
        params = new TreeMap();
        params.put(NAME, BusUtils.checLineName(model.line_name));
        params.put(LINEID, model.line_id);
        NetUtil.doGet(NetUtil.STOP_MSG, NetUtil.getStopMsgHeader(), params, new BusStringCallback() {
            @Override
            public void onBusResponse(String response, int id) {
                StopMsgModel model = ModelManger.getModel(response, StopMsgModel.class);
                if(null != model){
                   setDataByModel( model);
                }else {
                    TipsUtils.showSnackBar(rootView,"未知异常");
                }
                hideLoadingView();
            }

            @Override
            public void onBusError(Call call, Exception e, int id) {
                //super.onBusError(call, e, id);
                hideLoadingView();
                TipsUtils.showSnackBar(rootView,"未知异常");
            }
        });

        mAdapter = new LineTimeAdapter(null);
        mListview.setAdapter(mAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final StopMsgModel.LineResultsBean.StopsBean stopsBean = mAdapter.getDatas().get(position);
                params.put("stopid",stopsBean.id);
                params.put("direction",direction);
                showLoadingView();
                NetUtil.doGet(NetUtil.TIME_MSG, params, new BusStringCallback() {
                    String msg = "等待发车";
                    @Override
                    public void onBusResponse(String response, int id) {
                        BusTimeModel model = ModelManger.getModel(response, BusTimeModel.class);

                        if(null != model){
                            List<BusTimeModel.CarsBean> cars = model.cars;
                            if(null != cars && cars.size() > 0){
                                StringBuilder builder = new StringBuilder();
                                for (int i = 0; i < cars.size(); i++) {
                                    if(i != 0){
                                        builder.append("\n");
                                    }
                                    BusTimeModel.CarsBean car = cars.get(0);
                                    builder.append("公交站:"+stopsBean.zdmc);
                                    builder.append("\n");
                                    builder.append("车牌号"+car.terminal);
                                    builder.append(",还有"+car.stopdis+"站");
                                    builder.append(",约等待"+car.time+"秒");
                                }

                                msg = builder.toString();
                            }
                        }
                        hideLoadingView();
                        TipsUtils.showLongSnackBar(rootView,msg);
                    }

                    @Override
                    public void onBusError(Call call, Exception e, int id) {
                        super.onBusError(call, e, id);
                        hideLoadingView();
                        TipsUtils.showLongSnackBar(rootView,msg);
                    }
                });

            }
        });
    }



    public void setDataByModel(StopMsgModel dataByModel) {
        final StopMsgModel.LineResultsBean modelLine0 =  dataByModel.lineResults0;
        mLineMsgView0.setLeftText(modelLine0.stops.get(0).zdmc);
        mLineMsgView0.setRightText(modelLine0.stops.get(modelLine0.stops.size()-1).zdmc);

        mLineMsgView0.setSeleclt(true);
        showList(modelLine0);
        direction = "0";
        mLineMsgView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mLineMsgView0.getSeleectStatus()){
                    mLineMsgView0.setSeleclt(true);
                    showList(modelLine0);
                    direction = "0";
                    mLineMsgView1.setSeleclt(false);
                }
            }
        });
        final StopMsgModel.LineResultsBean modelLine1 =  dataByModel.lineResults1;
        mLineMsgView1.setSeleclt(false);
        mLineMsgView1.setLeftText(modelLine1.stops.get(0).zdmc);
        mLineMsgView1.setRightText(modelLine1.stops.get(modelLine1.stops.size()-1).zdmc);
        mLineMsgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mLineMsgView1.getSeleectStatus()){
                    mLineMsgView1.setSeleclt(true);
                    showList(modelLine1);
                    direction = "1";
                    mLineMsgView0.setSeleclt(false);
                }
            }
        });

    }

    private void showList(StopMsgModel.LineResultsBean modelLine) {
        mAdapter.upDateList(modelLine.stops,true);

    }


    public class LineTimeAdapter extends HxtListAdapter<StopMsgModel.LineResultsBean.StopsBean>{


        public LineTimeAdapter(List<StopMsgModel.LineResultsBean.StopsBean> datas) {
            super(datas);
        }

        @Override
        protected HxtListHolder<StopMsgModel.LineResultsBean.StopsBean> getHolder(final ViewGroup parent) {
            return new HxtListHolder<StopMsgModel.LineResultsBean.StopsBean>() {
                private TextView stopName;
                @Override
                protected View initView() {
                    View view = View.inflate(parent.getContext(), R.layout.item_linetime, null);
                     stopName =  (TextView) view.findViewById(R.id.stop_name);
                    return view;
                }

                @Override
                protected void refreshUI(StopMsgModel.LineResultsBean.StopsBean data, int postion) {
                    stopName.setText(++postion+"."+data.zdmc);
                }
            };
        }
    }
}
