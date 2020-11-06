package com.micloud.actuator.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.micloud.actuator.component.JsonData;
import com.micloud.actuator.component.health.HealthEntity;
import com.micloud.actuator.model.MsgReceiveAlarmVo;
import com.micloud.actuator.model.ReceiveVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
    private RestTemplate restTemplate;

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
    public String setHealthEntity(String defaultKettleUrl,String defaultUrl,String defaultIp, String uriPrefix){
        HealthEntity healthEntity = HealthEntity.getInstance();
        if(StringUtils.isNotBlank(defaultKettleUrl)){
            healthEntity.setDefaultKettleUrl(defaultKettleUrl);
        }
        if(StringUtils.isNotBlank(defaultUrl)){
            healthEntity.setDefaultUrl(defaultUrl);
        }
        if(StringUtils.isNotBlank(defaultIp)){
            healthEntity.setDefaultIp(defaultIp);
        }
        if(StringUtils.isNotBlank(uriPrefix)){
            healthEntity.setUriPrefix(uriPrefix);
        }
        return "操作成功";
    }



    @PostMapping(value = "/api/msg/receiveAllAlarm")
    @ResponseBody
    public JsonData receive_all_alarmApi(@RequestBody MsgReceiveAlarmVo outputValue) {
        try{
            return  accept(JSON.toJSONString(outputValue),HealthEntity.getInstance().getUriPrefix() + HealthEntity.getInstance().getDefaultIp() + HealthEntity.getInstance().getDefaultUrl());
        }catch(Exception e){
            log.info("转发接口失败, 参数：{}，异常信息：{}",JSON.toJSONString(outputValue),e.getMessage());
           return JsonData.fail("转发服务器接口调用失败,错误信息："+e.getMessage());
        }
    }


    @PostMapping(value = "/api/msg/receiveKettleAlarm")
    @ResponseBody
    public JsonData receive_kettle_alarmApi(@RequestBody ReceiveVo outputValue){
        try{
            return  accept(JSON.toJSONString(outputValue),HealthEntity.getInstance().getUriPrefix() + HealthEntity.getInstance().getDefaultIp() + HealthEntity.getInstance().getDefaultKettleUrl());
        }catch(Exception e){
            log.info("转发接口失败, 参数：{}，异常信息：{}",JSON.toJSONString(outputValue),e.getMessage());
            return JsonData.fail("转发服务器接口调用失败,错误信息："+e.getMessage());
        }
    }


    public JsonData accept(String param,String url){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return restTemplate.postForObject(url,  new HttpEntity<>(param, headers), JsonData.class);
    }

}
