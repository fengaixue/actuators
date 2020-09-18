package com.myActuator.actuators.component.health;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <h1> 配置参数试题类 </h1>
 *
 * @author 风清扬
 * @date 2020/09/18 14:13
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

    public static HealthEntity getInstance() {
        return InnerClass.healthEntity;
    }

}
