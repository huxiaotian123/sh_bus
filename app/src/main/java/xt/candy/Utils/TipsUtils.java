package xt.candy.Utils;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;

import xt.candy.app.BaseApp;


/**
 * Created by Administrator on 2016/9/14.
 */
public class TipsUtils {

    public static  void  showSnackBar(View rootlayout ,String str){
//         Snackbar.make(rootlayout, str, Snackbar.LENGTH_SHORT)
//                .setActionTextColor(Color.BLUE)
//                .setDuration(4000).show();
        TSnackbar.make(rootlayout,str,TSnackbar.LENGTH_SHORT).setActionTextColor(Color.BLUE).show();
    }

    public static  void  showLongSnackBar(View rootlayout ,String str){
//         Snackbar.make(rootlayout, str, Snackbar.LENGTH_SHORT)
//                .setActionTextColor(Color.BLUE)
//                .setDuration(4000).show();
        TSnackbar.make(rootlayout,str,TSnackbar.LENGTH_LONG).setActionTextColor(Color.BLUE).show();
    }

    public static void  showToast(String str){
        Toast toast = Toast.makeText(BaseApp.getApp(),str,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
