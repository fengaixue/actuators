package com.micloud.actuator.config;

import com.micloud.actuator.component.health.HealthEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/09/16 16:58
 */
@Configuration
public class RestfullConfig {


    public RestfullConfig(){
        HealthEntity healthEntity = HealthEntity.getInstance();
        healthEntity.setConnectTimeout(60 * 1000 * 3);
        healthEntity.setReadTimeout(60 * 1000 * 1);
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout( HealthEntity.getInstance().getConnectTimeout());
        factory.setReadTimeout( HealthEntity.getInstance().getReadTimeout());
        return factory;
    }
}
