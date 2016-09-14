package xt.candy.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：sh_bus
 * 类描述： 线路的model
 * 创建时间：2016/9/14 10:30
 */
public class LineMsgModel implements Parcelable {


    /**
     * start_latetime : 23:57
     * line_name : 973
     * end_earlytime : 05:30
     * start_earlytime : 05:30
     * end_stop : 蓝村路南泉路
     * line_id : 097300
     * start_stop : 上海南站（南广场）
     * end_latetime : 22:30
     */

    public String start_latetime;
    public String line_name;
    public String end_earlytime;
    public String start_earlytime;
    public String end_stop;
    public String line_id;
    public String start_stop;
    public String end_latetime;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.start_latetime);
        dest.writeString(this.line_name);
        dest.writeString(this.end_earlytime);
        dest.writeString(this.start_earlytime);
        dest.writeString(this.end_stop);
        dest.writeString(this.line_id);
        dest.writeString(this.start_stop);
        dest.writeString(this.end_latetime);
    }

    public LineMsgModel() {
    }

    protected LineMsgModel(Parcel in) {
        this.start_latetime = in.readString();
        this.line_name = in.readString();
        this.end_earlytime = in.readString();
        this.start_earlytime = in.readString();
        this.end_stop = in.readString();
        this.line_id = in.readString();
        this.start_stop = in.readString();
        this.end_latetime = in.readString();
    }

    public static final Parcelable.Creator<LineMsgModel> CREATOR = new Parcelable.Creator<LineMsgModel>() {
        @Override
        public LineMsgModel createFromParcel(Parcel source) {
            return new LineMsgModel(source);
        }

        @Override
        public LineMsgModel[] newArray(int size) {
            return new LineMsgModel[size];
        }
    };
}
