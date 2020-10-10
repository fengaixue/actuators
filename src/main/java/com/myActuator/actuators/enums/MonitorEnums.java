package com.myActuator.actuators.enums;

import org.springframework.stereotype.Component;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/01 16:44
 */
public final class MonitorEnums {

    /**
     * bat 执行方法和路径
     */
    public  static final String CMDPATH = "cmd /c start E://actuators/mine/stop2.bat";
    //public  static final String CMDPATH = "cmd /c start D://mineJar/stop2.bat";

    /**
     * 需要监控的项目的地址
     */
    public  static final String REMOTHOST = "http://localhost:9299/actuator/health";

    /**
     * 需要监控的项目的地址
     */
    public  static final String REMOTHOST2 = "http://localhost:9299/actuator/metrics/jvm.memory.used";

    /**
     * 需要监控的项目的地址
     */
    public  static final String REMOTHOST3 = "http://localhost:9299/actuator/metrics/process.cpu.usage";

    /**
     * 主状态 KEY
     */
    public  static final String KEY_STATUS = "status";

    /**
     * 状态
     */
    public  static final String UP = "UP";

    /**
     * 周期
     */
    public  static final long period = 1000 * 10 *  2;

    /**
     * 启动间隔
     */
    public  static final long startInterva = 1000 * 60 *  10;

    /**
     * 运行标记
     */
    public static final boolean FLAG = true;
    /**
     * 默认设置JVM大小 2G
     */
    public static final Long JVMSIZE = 2147483648L;

    /**
     * 开销比例
     */
    public static final Double CAST = 0.8;

    /**
     * 开销比例
     */
    public static final Double CASTCPU = 0.8;

}
