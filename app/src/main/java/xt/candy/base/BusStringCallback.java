package xt.candy.base;

import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/14.
 */
public abstract class BusStringCallback extends StringCallback {
    @Override
    public  void onError(Call call, Exception e, int id){
        onBusError(call,e,id);
    };

    @Override
    public  void onResponse(String response, int id){
        onBusResponse(response,id);
    };


    public abstract void onBusResponse(String response, int id);
    public abstract void onBusError(Call call, Exception e, int id);
}
