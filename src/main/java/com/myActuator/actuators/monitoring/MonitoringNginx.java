package com.myActuator.actuators.monitoring;

import com.myActuator.actuators.component.health.HealthEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/10/12 15:49
 */
//@Component
@Slf4j
public class MonitoringNginx implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {


    /*    Calendar calendar = Calendar.getInstance();
        Date fristTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String res = restTemplate.getForObject("http://47.93.34.228:7004/ngx_status", String.class);
                log.info(res);
            }
        },fristTime,5000);*/

    }


}
