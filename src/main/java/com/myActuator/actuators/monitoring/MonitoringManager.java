package com.myActuator.actuators.monitoring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1> 监听类 用户监控项目健康状态 </h1>
 * <h2> 单线程启动，true循环，靠sleep进行阻塞 </h2>
 * @author 风清扬
 * @date 2020/09/16 16:46
 */
@Component
public class MonitoringManager implements CommandLineRunner {

    @Autowired
    private  RestTemplate  restTemplate;

    //private  static final String REMOTEHOST = "";


    public void exeu(Object obj) throws  Exception{
        String cmd = "cmd /c start D://mineJar" + "/stop2.bat";
        Process ps = Runtime.getRuntime().exec(cmd);
        ps.waitFor();
        System.out.println("执行了bat>> stop2");
        //休息10分钟 用于启动项目时间
        Thread.sleep(1000 * 60 *  10);
    }

    @Override
    public void run(String... args) throws Exception {
        Object obj=new Object();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                //对象锁: notirty wait
                // synchronized (obj) {
                System.out.println("获取健康数据线程启动。。。。");
                while (true){
                    try {
                        String jsonStr = restTemplate.getForObject("http://localhost:9099/actuator/health", String.class);
                        System.out.println(jsonStr);
                        JSONObject jsonObject = JSON.parseObject(jsonStr);
                        String status = jsonObject.getString("status");
                        if(!"UP".equals(status)){
                            exeu(obj);
                        }
                    } catch (Exception e) {
                        try{
                            exeu(obj);
                        }catch(Exception a){
                            System.out.println(2);
                            a.printStackTrace();
                        }
                    }
                    try{
                        //每10秒执行一次
                        Thread.sleep(1000 * 10 *  1);
                    }catch(Exception e){
                        System.out.println(1);
                        e.printStackTrace();
                    }
                }
                // }
            }
        },"D1");
        t1.start();
    }
}
