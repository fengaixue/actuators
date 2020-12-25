package com.micloud.actuator;

import com.micloud.actuator.component.health.HealthEntity;
import com.micloud.actuator.enums.MonitorEnums;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Configuration
@SpringBootApplication
@EnableScheduling
//@EnableEurekaClient
public class ActuatorRedisApplication {

	public static void main(String[] args) {
		initData();
		SpringApplication.run(ActuatorRedisApplication.class, args);
	}

	/**
	 * 全局初始化参数
	 */
	public static void initData(){
		HealthEntity.getInstance().setDefaultIp(MonitorEnums.DEFAULT_IP);
		HealthEntity.getInstance().setDefaultPort(MonitorEnums.DEFAULT_PORT);
		HealthEntity.getInstance().setDefaultPsd(MonitorEnums.DEFAULT_PSD);
		HealthEntity.getInstance().setFlag(MonitorEnums.FLAG);
		HealthEntity.getInstance().setStartInterva(MonitorEnums.startInterva);
		HealthEntity.getInstance().setPeriod(MonitorEnums.period);
		HealthEntity.getInstance().setRemotHost(MonitorEnums.remotHost);
	}
}
