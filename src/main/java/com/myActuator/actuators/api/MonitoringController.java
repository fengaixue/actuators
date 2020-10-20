package com.myActuator.actuators.api;

import com.alibaba.fastjson.JSON;
import com.myActuator.actuators.component.health.HealthEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private MonitoringEmail monitoringEmail;


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

   @GetMapping("/sendEmail")
   public String sendEmail(String startTime,String server, String msg){
        try{
            Map params = new HashMap();
            params.put("startTime",startTime);
            params.put("server", server);
            params.put("msg", msg);
            monitoringEmail.templet("健康监控服务通知",params);
            return "已发送";
        }catch(Exception e){
            log.error("发送邮件接口被调用方法出错sendEmail(),信息：{}",e.getMessage());
            return "发送失败";
        }

   }

}
