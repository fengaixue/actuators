package com.micloud.actuator.api;

import com.alibaba.fastjson.JSON;
import com.micloud.actuator.component.health.HealthEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

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
        model.addAttribute("menus", HealthEntity.getInstance().getMenus());
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
        }catch(Exception e){
           log.error(e.getMessage());
        }
        return "/pages/monitoring";
    }



}
