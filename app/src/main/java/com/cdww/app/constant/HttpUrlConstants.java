package com.cdww.app.constant;

/**
 * 存储各系统URL配置参数
 */
public class HttpUrlConstants {
    public final static String MARKETING_SERVICE = "192.168.2.100:8091/UC0000";
    public final static String BERS_SERVICE="172.16.1.31:8080";
    //登陆
    public final static String LOGIN_SERVICE = String.format("http://%s/manageCenter/v1/authentication1",MARKETING_SERVICE);
    //用户权限
    public final static String USER_AUTH = String.format("http://%s/app/queryUesrFunction",MARKETING_SERVICE);
    //***业扩URL***
    //待办事宜
    public final static String DBSY_URL=String.format("http://%s/h5/pages/dbsy/dbsylist/dbsylist",BERS_SERVICE);
    //发起流程
    public final static String FQLC_URL=String.format("http://%s/h5/pages/fqlc/fqlclist/fqlclist",BERS_SERVICE);
    //我的请求
    public final static String WDQQ_URL=String.format("http://%s/h5/pages/wdqq/wdqqlist/wdqqlist",BERS_SERVICE);
    //已办事宜
    public final static String YBSY_URL=String.format("http://%s/h5/pages/ybsy/ybsylist/ybsylist",BERS_SERVICE);
    //
    public final static String BJSY_URL=String.format("http://%s/h5/pages/bjsy/bjsylist/bjsylist",BERS_SERVICE);

    //***业扩URL END ***



    public final static String EWIDSOM_APP_DEBUG = "EWIDSOM_APP_DEBUG";
    public final static String EWIDSOM_APP_WARN = "EWIDSOM_APP_WARN";
}
