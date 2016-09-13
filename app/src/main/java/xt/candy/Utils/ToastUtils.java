package xt.candy.Utils;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;



/**
 * Created by Administrator on 2016/9/14.
 */
public class ToastUtils {

    public static  void  showToast(View rootlayout ,String str){
        Snackbar.make(rootlayout, str, Snackbar.LENGTH_SHORT)
//                .setAction("Undo", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // Perform anything for the action selected
//                    }
//                })
                .setActionTextColor(Color.BLUE)
                .setDuration(4000).show();
    }
}
