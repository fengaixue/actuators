package com.myActuator.actuators.api;

import com.alibaba.fastjson.JSON;
import com.myActuator.actuators.component.health.HealthEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <h1> 控制参数API  </h1>
 *
 * @author 风清扬
 * @date 2020/09/18 14:32
 */
@Controller
public class MonitoringApi {


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
     * 设置周期
     * @param StartInterva
     * @param cmdPath
     * @param remotHost
     * @return
     */
    @GetMapping("/api/setHealthEntity")
    @ResponseBody
    public String setHealthEntity(Long StartInterva, String cmdPath,
                                  String remotHost,Boolean flag,Integer readTimeout,
                                  Integer connectTimeout,Double cast,Long jvmmMaxSize,
                                  String remotHost2,Double castCpu,String remotHost3){
         HealthEntity healthEntity = HealthEntity.getInstance();
         if(StartInterva != null && StartInterva > 0){
             healthEntity.setStartInterva(StartInterva);
         }
        if(flag != null){
            healthEntity.setFlag(flag);
        }
         if(StringUtils.isNotBlank(cmdPath)){
             healthEntity.setCmdPath(cmdPath);
         }
         if(StringUtils.isNotBlank(remotHost)){
            healthEntity.setRemotHost(remotHost);
         }
        if(readTimeout != null && readTimeout > 0){
            healthEntity.setReadTimeout(readTimeout);
        }
        if(connectTimeout != null && connectTimeout > 0){
            healthEntity.setConnectTimeout(connectTimeout);
        }
        if(jvmmMaxSize != null && jvmmMaxSize > 0){
            healthEntity.setJvmmMaxSize(jvmmMaxSize);
        }
        if(cast != null && cast > 0){
            healthEntity.setCast(cast);
        }
        if(StringUtils.isNotBlank(remotHost2)){
            healthEntity.setRemotHostJvm(remotHost2);
        }
        if(castCpu != null && castCpu > 0){
            healthEntity.setCastCpu(castCpu);
        }
        if(StringUtils.isNotBlank(remotHost3)){
            healthEntity.setRemotHostCpu(remotHost3);
        }
        return "操作成功";
    }


}
