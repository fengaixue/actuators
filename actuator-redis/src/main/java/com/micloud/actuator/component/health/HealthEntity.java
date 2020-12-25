package com.micloud.actuator.component.health;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

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


    @Getter
    @Setter
    private Integer  defaultPort;

    @Getter
    @Setter
    private String  defaultIp;
    @Getter
    @Setter
    private String  defaultPsd;
    /** 扫描周期 **/
    @Getter
    @Setter
    private long period;
    /** 启动间隔 **/
    @Getter
    @Setter
    private long startInterva;
    /** 是否运行bat标志位 **/
    @Getter
    @Setter
    private boolean flag;
    /** bat 需要监控的项目的地址 **/
    @Getter
    @Setter
    private String remotHost;


    public static HealthEntity getInstance() {
        return InnerClass.healthEntity;
    }

}
