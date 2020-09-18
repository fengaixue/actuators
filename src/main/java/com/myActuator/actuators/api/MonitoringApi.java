package com.myActuator.actuators.api;

import com.alibaba.fastjson.JSON;
import com.myActuator.actuators.component.health.HealthEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/09/18 14:32
 */
@RestController
public class MonitoringApi {


    /**
     * 获取配置
     * @return
     */
    @GetMapping("/api/healthEntity")
    public String getHealthEntity(){
        String json = JSON.toJSONString(HealthEntity.getInstance());
        return json;
    }

    /**
     * 设置周期
     * @param StartInterva
     * @param cmdPath
     * @param remotHost
     * @return
     */
    @GetMapping("/api/setHealthEntity")
    public String setHealthEntity(Long StartInterva, String cmdPath, String remotHost){
         HealthEntity healthEntity = HealthEntity.getInstance();
         if(StartInterva != null && StartInterva > 0){
             healthEntity.setStartInterva(StartInterva);
         }
         if(StringUtils.isNotBlank(cmdPath)){
             healthEntity.setCmdPath(cmdPath);
         }
         if(StringUtils.isNotBlank(remotHost)){
            healthEntity.setRemotHost(remotHost);
         }
        return "操作成功";
    }
}
