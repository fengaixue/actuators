package com.micloud.actuator.monitoring;

import com.micloud.actuator.component.health.HealthEntity;
import com.micloud.actuator.service.PorcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <h1> 监听类 用户监控项目健康状态 </h1>
 * <h2> 单线程启动，true循环，靠sleep进行阻塞 </h2>
 * @author 风清扬
 * @date 2020/09/16 16:46
 */
@Component
@Slf4j
public class MonitoringRedis implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PorcessService PorcessService;

    /**
     * @throws Exception
     */
    public void exeu() {
            String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String msg = "Redis服务不可用";
            try{
                String res =  restTemplate.getForObject(String.format("%s?startTime=%s&server=%s&msg=%s",HealthEntity.getInstance().getRemotHost(),startTime,"redis",msg), String.class);
                log.info("***######[{}]#########***",res);
                Thread.sleep(HealthEntity.getInstance().getStartInterva());
            }catch(Exception e){
                e.printStackTrace();
                log.error("本机调用发送邮件接口方法出错,信息：{}",e.getMessage());
            }
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("获取redis状态线程启动。。。。");
        Calendar calendar = Calendar.getInstance();
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               HealthEntity healthEntity = HealthEntity.getInstance();
                if(healthEntity.isFlag()){
                    Boolean flag = PorcessService.getRedisIsOk(healthEntity.getDefaultIp(),healthEntity.getDefaultPort(),healthEntity.getDefaultPsd());
                    if(!flag){
                        exeu();
                    }
                }
            }
        }, firstTime, HealthEntity.getInstance().getPeriod());
    }
}