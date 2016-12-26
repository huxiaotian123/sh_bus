package xt.candy.Utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

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
       if(isNum(lineName)){
           lineName += "路";
       }
        return lineName;
    }


    public static boolean isNum(String str){
        String zhengZe = "^[0-9]*$";
        return str.matches(zhengZe);
    }
}
