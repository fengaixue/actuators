package com.micloud.actuator;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class MicloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicloudZuulApplication.class,args);
    }

}
