package com.myActuator.actuators.api;

import com.alibaba.fastjson.JSON;
import com.myActuator.actuators.component.health.HealthEntity;
import com.myActuator.actuators.enums.MonitorEnums;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class MonitoringController {

    @RequestMapping("/index")
    public String pageIndex(ModelMap model){
        model.addAttribute("menus",HealthEntity.getInstance().getMenus());
        System.out.println(JSON.toJSONString(HealthEntity.getInstance().getMenus()));
        return "/pages/index";
    }
    @RequestMapping("/monitoring/{hrefA}/{hrefH}")
    public String pageMonitor(@PathVariable("hrefA")String hrefA, @PathVariable("hrefH")String hrefH,ModelMap model){
        model.addAttribute("menus",HealthEntity.getInstance().getMenus());
        model.addAttribute("hrefA",hrefA);
        model.addAttribute("hrefH",hrefH);
        model.addAttribute("healthEntity",HealthEntity.getInstance());
        return "/pages/monitoring";
    }



}
