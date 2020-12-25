package com.micloud.actuator.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/21 9:26
 */
public final class MonitorEnums {

    /**
     *  默认端口类型
     * */
    public  static final String  DEFAULT_IP = "127.0.0.1";
    /**
     * 默认端口
     * */
    public  static final Integer  DEFAULT_PORT = 6379;
    /**
     * 默认密码
     * */
    public  static final String  DEFAULT_PSD = "123456";
    /**
     * 周期
     */
    public  static final long period = 1000 * 10 *  2;

    /**
     * 启动间隔
     */
    public  static final long startInterva = 1000 * 60 *  5;
    /**
     * 运行标记
     */
    public static final boolean FLAG = true;

    /**
     * 地址
     * **/
    public  static final String  remotHost = "http://localhost:3001/sendEmail";

}
