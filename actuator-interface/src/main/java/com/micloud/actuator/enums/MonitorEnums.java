package com.micloud.actuator.enums;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/21 9:26
 */
public final class MonitorEnums {

    /**
     * 只针对 dicID = 105 类型进行推送报警
     * */
    public  static final String  DEFAULT_KETTLE_URL = "/api/msg/receiveKettleAlarm";
    /**
     *  sysDic 任意 ID 类型进行推送报警
     * */
    public  static final String  DEFAULT_URL = "/api/msg/receiveAllAlarm";
    /**
     *  默认端口类型
     * */
    public  static final String  DEFAULT_IP = "localhost:9099";



    public  static final String  URI_PREFIX = "http://";

}
