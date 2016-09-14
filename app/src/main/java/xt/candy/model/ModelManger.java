package xt.candy.model;

import com.google.gson.Gson;

/**
 * 项目名称：sh_bus
 * 类描述：
 * 创建时间：2016/9/14 10:37
 */
public class ModelManger {
    public static Gson gson = new Gson();

    public static <T>T getModel(String response,Class<T> clazz){
        T t = null;
        try {
            t = gson.fromJson(response, clazz);
        }catch (Exception e){
        }

        return t;
    }
}
