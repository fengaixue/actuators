package com.micloud.actuator;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class MicloudActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicloudActuatorApplication.class,args);
    }

}
