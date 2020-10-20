package com.myActuator.actuators;

import com.alibaba.fastjson.JSON;
import com.myActuator.actuators.component.health.HealthEntity;
import com.myActuator.actuators.enums.MonitorEnums;
import com.myActuator.actuators.model.Menus;
import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

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
