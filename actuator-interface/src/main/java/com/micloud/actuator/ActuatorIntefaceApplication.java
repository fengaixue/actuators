package com.micloud.actuator;

import com.alibaba.fastjson.JSON;
import com.micloud.actuator.component.health.HealthEntity;
import com.micloud.actuator.enums.MonitorEnums;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
@EnableScheduling
//@EnableEurekaClient
public class ActuatorIntefaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorIntefaceApplication.class, args);
		initData();
	}

	/**
	 * 全局初始化参数
	 */
	public static void initData(){
		HealthEntity.getInstance().setDefaultIp(MonitorEnums.DEFAULT_IP);
		HealthEntity.getInstance().setDefaultKettleUrl(MonitorEnums.DEFAULT_KETTLE_URL);
		HealthEntity.getInstance().setDefaultUrl(MonitorEnums.DEFAULT_URL);
		HealthEntity.getInstance().setUriPrefix(MonitorEnums.URI_PREFIX);
	}
}
