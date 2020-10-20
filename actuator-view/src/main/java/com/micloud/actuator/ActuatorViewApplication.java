package com.micloud.actuator;

import com.micloud.actuator.component.health.HealthEntity;
import com.micloud.actuator.enums.MonitorEnums;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/20 18:01
 */
@Configuration
@SpringBootApplication
@EnableScheduling
public class ActuatorViewApplication {

    public static void main(String[] args) {

        SpringApplication.run(ActuatorViewApplication.class, args);
        initData();
    }

    /**
     * 全局初始化参数
     */
    public static void initData(){
        HealthEntity.getInstance().setMenus(JSON.parseArray(MonitorEnums.MENUS));
        HealthEntity.getInstance().setAddresss(MonitorEnums.emails);
    }

}
