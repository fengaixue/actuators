package com.myActuator.actuators.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myActuator.actuators.component.health.HealthEntity;
import com.myActuator.actuators.enums.MonitorEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import sun.security.provider.ConfigFile;

import java.io.*;
import java.util.Properties;

/**
 * <h1> 监控页面调整 </h1>
 *
 * @author 风清扬
 * @date 2020/10/10 10:03
 */
@Controller
@Slf4j
public class MonitoringController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String pageIndex(ModelMap model){
        model.addAttribute("menus",HealthEntity.getInstance().getMenus());
        System.out.println(JSON.toJSONString(HealthEntity.getInstance().getMenus()));
        return "/pages/index";
    }
    @RequestMapping("/monitoring")
    public String pageMonitor(String hrefA, String hrefH,ModelMap model){
        model.addAttribute("menus",HealthEntity.getInstance().getMenus());
        model.addAttribute("hrefA",hrefA);
        model.addAttribute("hrefH",hrefH);
        try {
            model.addAttribute("healthEntity", restTemplate.getForObject( "http://"+ hrefH + "/api/healthEntity", HealthEntity.class));
            model.addAttribute("systemCpuCount",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/system.cpu.count", String.class));
            model.addAttribute("systemCpuUsage",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/system.cpu.usage", String.class));
            model.addAttribute("processStartTime",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/process.start.time", String.class));
            model.addAttribute("processUptime",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/process.uptime", String.class));
            model.addAttribute("processCpuUsage",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/process.cpu.usage", String.class));
            model.addAttribute("jvmMemoryMax",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/jvm.memory.max", String.class));
            model.addAttribute("jvmMemoryCommitted",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/jvm.memory.committed", String.class));
            model.addAttribute("jvmMemoryUsed",restTemplate.getForObject("http://"+ hrefA + "/actuator/metrics/jvm.memory.used", String.class));
        }catch(Exception e){
           log.error(e.getMessage());
        }
        return "/pages/monitoring";
    }



}
