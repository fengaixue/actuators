package com.myActuator.actuators;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
@EnableAdminServer
@EnableScheduling
public class ActuatorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorsApplication.class, args);
	}

}
