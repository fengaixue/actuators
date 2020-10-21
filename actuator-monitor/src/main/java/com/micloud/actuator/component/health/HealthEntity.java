package com.micloud.actuator.component.health;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/21 9:24
 */
@Component
public class HealthEntity {

    private HealthEntity(){
    }

    private static class InnerClass{
        private static HealthEntity healthEntity = new HealthEntity();
    }

    private HealthEntity(long StartInterva, long period, String cmdPath, String remotHost,boolean flag) {
        this.period = period;
        this.startInterva = StartInterva;
        this.cmdPath = cmdPath;
        this.remotHost = remotHost;
        this.flag = flag;
    }

    /** 扫描周期 **/
    @Getter
    @Setter
    private long period;
    /** 启动间隔 **/
    @Getter
    @Setter
    private long startInterva;
    /** bat 执行方法和路径 **/
    @Getter
    @Setter
    private String cmdPath;
    /** bat 需要监控的项目的地址 **/
    @Getter
    @Setter
    private String remotHost;
    /** 是否运行bat标志位 **/
    @Getter
    @Setter
    private boolean flag;
    /** **/
    @Getter
    @Setter
    private Integer readTimeout;
    /** **/
    @Getter
    @Setter
    private Integer connectTimeout;

    /** JVM设置的可用内存 **/
    @Getter
    @Setter
    private Long jvmmMaxSize;

    /** 开销 **/
    @Getter
    @Setter
    private Double cast;

    /** 开销 **/
    @Getter
    @Setter
    private Double castCpu;

    /**  **/
    @Getter
    @Setter
    private String remotHostJvm;

    /**  **/
    @Getter
    @Setter
    private String remotHostCpu;


    /*
     * 菜单数据
     * */
    @Getter
    @Setter
    private List<Object> menus;


    public static HealthEntity getInstance() {
        return InnerClass.healthEntity;
    }

}
