package xt.candy.model;

import java.util.List;

/**
 * 项目名称：sh_bus
 * 类描述：
 * 创建时间：2016/9/14 11:15
 */
public class StopMsgModel {

    /**
     * stops : [{"id":"1","zdmc":"蓝村路南泉路"},{"id":"2","zdmc":"东方路蓝村路"},{"id":"3","zdmc":"浦建路东方路"},{"id":"4","zdmc":"临沂北路浦建路"},{"id":"5","zdmc":"临沂北路北园路"},{"id":"6","zdmc":"临沂北路龙阳路"},{"id":"7","zdmc":"临沂路东三里桥路"},{"id":"8","zdmc":"临沂路兰陵路"},{"id":"9","zdmc":"临沂路浦三路"},{"id":"10","zdmc":"临沂路华丰路"},{"id":"11","zdmc":"东明路高科西路"},{"id":"12","zdmc":"东明路昌里东路"},{"id":"13","zdmc":"东明路成山路"},{"id":"14","zdmc":"成山路云台路"},{"id":"15","zdmc":"成山路洪山路"},{"id":"16","zdmc":"上南路德州路"},{"id":"17","zdmc":"上南路杨思路"},{"id":"18","zdmc":"上南路海阳路"},{"id":"19","zdmc":"上南路华夏西路"},{"id":"20","zdmc":"凌兆路上南路"},{"id":"21","zdmc":"凌兆路灵岩南路"},{"id":"22","zdmc":"上浦路长清路"},{"id":"23","zdmc":"上浦路济阳路"},{"id":"24","zdmc":"龙川北路上中路"},{"id":"25","zdmc":"百色路龙川北路"},{"id":"26","zdmc":"汇成新村"},{"id":"27","zdmc":"华东理工大学"},{"id":"28","zdmc":"石龙路老沪闵路"},{"id":"29","zdmc":"上海南站（南广场）"}]
     * direction : false
     */

    public LineResultsBean lineResults1;

    public LineResultsBean lineResults0;

    /**
     * stops : [{"id":"1","zdmc":"上海南站（南广场）"},{"id":"2","zdmc":"石龙路老沪闵路"},{"id":"3","zdmc":"华东理工大学"},{"id":"4","zdmc":"汇成新村"},{"id":"5","zdmc":"龙川北路百色路"},{"id":"6","zdmc":"华夏西路林浦路"},{"id":"7","zdmc":"上浦路济阳路"},{"id":"8","zdmc":"上浦路长清路"},{"id":"9","zdmc":"灵岩南路凌兆路"},{"id":"10","zdmc":"凌兆路上南路"},{"id":"11","zdmc":"上南路华夏西路"},{"id":"12","zdmc":"上南路海阳路"},{"id":"13","zdmc":"上南路杨思路"},{"id":"14","zdmc":"上南路德州路"},{"id":"15","zdmc":"成山路洪山路"},{"id":"16","zdmc":"成山路云台路"},{"id":"17","zdmc":"东明路成山路"},{"id":"18","zdmc":"东明路昌里东路"},{"id":"19","zdmc":"东明路高科西路"},{"id":"20","zdmc":"临沂路华丰路"},{"id":"21","zdmc":"临沂路浦三路"},{"id":"22","zdmc":"临沂路兰陵路"},{"id":"23","zdmc":"临沂路东三里桥路"},{"id":"24","zdmc":"临沂北路龙阳路"},{"id":"25","zdmc":"临沂北路北园路"},{"id":"26","zdmc":"临沂北路浦建路"},{"id":"27","zdmc":"蓝村路南泉路"}]
     * direction : true
     */

    public static class LineResultsBean {
        public String direction;
        /**
         * id : 1
         * zdmc : 蓝村路南泉路
         */

        public List<StopsBean> stops;

        public static class StopsBean {
            public String id;
            public String zdmc;
        }
    }


}
