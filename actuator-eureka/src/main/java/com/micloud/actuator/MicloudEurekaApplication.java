package com.micloud.actuator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicloudEurekaApplication.class,args);
    }
}
