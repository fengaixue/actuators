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
    //public  static final String CMDPATH = "cmd /c start E://actuators/mine/stop2.bat";
    public  static final String CMDPATH = "cmd /c start D://mineJar/stop2.bat";

    /**
     * 需要监控的项目的地址
     */
    public  static final String REMOTHOST = "http://localhost:9099/actuator/health";

    /**
     * 需要监控的项目的地址
     */
    public  static final String REMOTHOST2 = "http://localhost:9099/actuator/metrics/jvm.memory.used";

    /**
     * 需要监控的项目的地址
     */
    public  static final String REMOTHOST3 = "http://localhost:9099/actuator/metrics/process.cpu.usage";

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
    public  static final long startInterva = 1000 * 60 *  5;

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
    public static final Double CAST = 0.85;

    /**
     * 开销比例
     */
    public static final Double CASTCPU = 0.9;


    /**
     * 初始化菜单项
     * */
    public static final String MENUS = "[{\"name\":\"本机项目\",\"hrefH\":\"localhost:3002\",\"hrefA\":\"localhost:9099\"}]";
    //public static final String MENUS = "[{\"name\":\"Mic-DASP1\",\"hrefH\":\"10.51.94.21:3001\",\"hrefA\":\"10.51.94.21:9199\"},{\"name\":\"Mic-DASP2\",\"hrefH\":\"10.51.94.22:3001\",\"hrefA\":\"10.51.94.22:9199\"},{\"name\":\"Mic-DASP3\",\"hrefH\":\"192.168.3.12:3001\",\"hrefA\":\"192.168.3.12:9099\"}]";

}
