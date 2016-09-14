package xt.candy.base;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/13.
 */
public class BaseApp extends Application {

    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        //okhttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);

    }

    public static Context getApp(){
        return app;
    }

}
