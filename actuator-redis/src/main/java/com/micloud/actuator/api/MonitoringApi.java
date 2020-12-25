package com.micloud.actuator.api;

import com.alibaba.fastjson.JSON;
import com.micloud.actuator.component.health.HealthEntity;
import com.micloud.actuator.service.PorcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

/**
 * <h1> 控制参数API  </h1>
 *
 * @author 风清扬
 * @date 2020/09/18 14:32
 */
@Controller
@Slf4j
public class MonitoringApi {

    @Autowired
    private PorcessService PorcessService;


    /**
     * 获取配置
     * @return
     */
    @GetMapping("/api/healthEntity")
    @ResponseBody
    public String getHealthEntity(){
        String json = JSON.toJSONString(HealthEntity.getInstance());
        return json;
    }

    /**
     * @return
     */
    @GetMapping("/api/setHealthEntity")
    @ResponseBody
    public String setHealthEntity(String url, int port,String password){
        Boolean res = PorcessService.getRedisIsOk(url, port,password);
        if (res) {
            log.info("redis缓存有效！" + res);
        } else {
            log.info("redis缓存失败！" + res);
        }
        return res ? "redis缓存有效！" : "redis缓存失败！";
    }





}
