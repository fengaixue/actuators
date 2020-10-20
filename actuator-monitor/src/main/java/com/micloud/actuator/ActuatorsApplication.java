package com.micloud.actuator;

import com.alibaba.fastjson.JSON;
import com.micloud.actuator.component.health.HealthEntity;
import com.micloud.actuator.enums.MonitorEnums;
import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
@EnableScheduling
public class ActuatorsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ActuatorsApplication.class, args);
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
