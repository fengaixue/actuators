package com.myActuator.actuators.config;

import com.myActuator.actuators.component.health.HealthEntity;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

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
        healthEntity.setReadTimeout(60 * 1000 * 3);
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
