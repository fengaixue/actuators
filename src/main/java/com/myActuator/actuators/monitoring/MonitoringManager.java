package com.myActuator.actuators.monitoring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myActuator.actuators.component.health.HealthEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <h1> 监听类 用户监控项目健康状态 </h1>
 * <h2> 单线程启动，true循环，靠sleep进行阻塞 </h2>
 * @author 风清扬
 * @date 2020/09/16 16:46
 */
@Component
@Slf4j
public class MonitoringManager implements CommandLineRunner {

    @Autowired
    private  RestTemplate  restTemplate;
    /**
     * bat 执行方法和路径
     */
    private  static final String CMDPATH = "cmd /c start D://mineJar/stop2.bat";

    /**
     * 需要监控的项目的地址
     */
    private  static final String REMOTHOST = "http://localhost:9099/actuator/health";

    /**
     * 主状态 KEY
     */
    private  static final String KEY_STATUS = "status";

    /**
     * 状态
     */
    private  static final String UP = "UP";

    /**
     * 周期
     */
    private  static final long period = 1000 * 10 *  1;

    /**
     * 启动间隔
     */
    private  static final long startInterva = 1000 * 60 *  10;

    /**
     * 初始化方法 设置循环周期、等待周期
     */
    public MonitoringManager(){
        HealthEntity healthEntity = HealthEntity.getInstance();
        healthEntity.setPeriod(period);
        healthEntity.setStartInterva(startInterva);
        healthEntity.setCmdPath(CMDPATH);
        healthEntity.setRemotHost(REMOTHOST);
    }

    /**
     * bat 执行方法 每次执行之后会休眠10分钟
     * @param obj
     * @throws Exception
     */
    public void exeu(Object obj) throws  Exception{
        log.info(" start time:{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Process ps = Runtime.getRuntime().exec(HealthEntity.getInstance().getCmdPath());
        ps.waitFor();
        log.info(" run restart bat :{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //休息10分钟 用于启动项目时间
        Thread.sleep(HealthEntity.getInstance().getStartInterva());
    }

    @Override
    public void run(String... args) throws Exception {
        Object obj=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("获取健康数据线程启动。。。。");
                Calendar calendar = Calendar.getInstance();
                Date firstTime = calendar.getTime();

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            String jsonStr = restTemplate.getForObject(HealthEntity.getInstance().getRemotHost(), String.class);
                            //log.info(jsonStr);
                            JSONObject jsonObject = JSON.parseObject(jsonStr);
                            String status = jsonObject.getString(KEY_STATUS);
                            if(!UP.equals(status)){
                                exeu(obj);
                            }
                        } catch (Exception e) {
                            try{
                                exeu(obj);
                            }catch(Exception a){
                                log.error("exeu run error >> {}",a.getMessage());
                            }
                        }
                    }
                }, firstTime, HealthEntity.getInstance().getPeriod());
            }
        });
        t1.start();
    }
}
//多线程方式执行，对象锁，较为不妥，唤醒时间未按设定时间完成唤醒
/* while (true){
    try {
        String jsonStr = restTemplate.getForObject(REMOTHOST, String.class);
        //log.info(jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String status = jsonObject.getString(KET_STATUS);
        if(!UP.equals(status)){
            exeu(obj);
        }
    } catch (Exception e) {
        try{
            exeu(obj);
        }catch(Exception a){
            log.error("exeu run error >> {}",a.getMessage());
        }
    }
    try{
        //每10秒执行一次
        Thread.sleep(1000 * 10 *  1);
    }catch(Exception e){
        log.error("sleep run error >> {}",e.getMessage());
    }
}*/