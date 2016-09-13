package xt.candy.Utils;

import android.support.annotation.NonNull;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.OkHttpClient;

import java.util.TreeMap;

/**
 * Created by Administrator on 2016/9/14.
 */
//网路的工具类
public class NetUtil {

    public static String LINE_MSG = "http://apps.eshimin.com/traffic/gjc/getBusBase";//获取线路
    public static String STOP_MSG = "http://apps.eshimin.com/traffic/gjc/getBusStop";//获取线路站点
   // "http://apps.eshimin.com/traffic/gjc/getArriveBase
    // ?name=" + DisplayMessageActivity.this.line_name +
    // &lineid=" + DisplayMessageActivity.this.line_id +
    // "&stopid=" + DisplayMessageActivity.this.stopid +
    // "&direction=" + DisplayMessageActivity.this.direction

   //get请求
    public static void doGet(String url, @NonNull TreeMap<String, String> params, StringCallback callback) {
        OkHttpUtils.get().url(url).headers(new TreeMap<String, String>()).params(params).build().execute(callback);
    }

    //get请求
    public static void doGet(String url, @NonNull TreeMap<String, String> headers, @NonNull TreeMap<String, String> params, StringCallback callback) {
        OkHttpUtils.get().url(url).headers(headers).params(params).build().execute(callback);
    }


    //获取线路信息通用的头部
    public static TreeMap<String, String> getStopMsgHeader(){
        TreeMap map = new TreeMap();
        map.put("Referer","http://apps.eshimin.com/traffic/pages/gjc/bus.jsp");
        map.put("User-Agent",  "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");
        return  map;
    }
}
