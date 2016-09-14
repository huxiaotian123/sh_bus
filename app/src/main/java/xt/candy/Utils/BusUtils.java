package xt.candy.Utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * 项目名称：sh_bus
 * 类描述：和项目相关的工具栏
 * 创建时间：2016/9/14 13:17
 */
public class BusUtils {

    //手动添加路
    @NonNull
    public static String checLineName(String lineName) {
        if(TextUtils.isEmpty(lineName)){
            return "";
        }
        if (!lineName.contains("路")) {
            lineName += "路";
        }
        return lineName;
    }
}
