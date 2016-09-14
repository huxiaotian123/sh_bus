package xt.candy.model;

import java.util.List;

/**
 * 项目名称：sh_bus
 * 类描述：
 * 创建时间：2016/9/14 15:28
 */
public class BusTimeModel {
    /**
     * time : 1498
     * distance : 0
     * terminal : 沪D-92666
     * stopdis : 13
     */

    public List<CarsBean> cars;

    public static class CarsBean {
        public String time;
        public String distance;
        public String terminal;
        public String stopdis;
    }
}
