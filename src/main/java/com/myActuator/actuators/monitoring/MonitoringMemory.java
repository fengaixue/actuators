package com.myActuator.actuators.monitoring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myActuator.actuators.api.MonitoringEmail;
import com.myActuator.actuators.component.health.HealthEntity;
import com.myActuator.actuators.enums.MonitorEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
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
public class MonitoringMemory implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MonitoringEmail monitoringEmail;

    /**
     * 初始化方法 设置循环周期、等待周期
     */
    public MonitoringMemory() {
        HealthEntity healthEntity = HealthEntity.getInstance();
        healthEntity.setPeriod(MonitorEnums.period);
        healthEntity.setStartInterva(MonitorEnums.startInterva);
        healthEntity.setCmdPath(MonitorEnums.CMDPATH);
        healthEntity.setRemotHost(MonitorEnums.REMOTHOST);
        healthEntity.setFlag(MonitorEnums.FLAG);
        healthEntity.setJvmmMaxSize(MonitorEnums.JVMSIZE);
        healthEntity.setCast(MonitorEnums.CAST);
        healthEntity.setRemotHostJvm(MonitorEnums.REMOTHOST2);
        healthEntity.setRemotHostCpu(MonitorEnums.REMOTHOST3);
        healthEntity.setCastCpu(MonitorEnums.CASTCPU);
    }

    /**
     * bat 执行方法 每次执行之后会休眠10分钟
     *
     * @param obj
     * @throws Exception
     */
    public void exeu(Object obj) {
        try {
            Process ps = Runtime.getRuntime().exec(HealthEntity.getInstance().getCmdPath());
            ps.waitFor();
            log.info("健康监控程序*****===》启动了Bat,并发送了邮件,时间：{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            Map<String, String> params = new HashMap<>();
            params.put("startTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            params.put("server", "10.51.130.14");
            params.put("msg", "健康监控程序重启了平台服务");
            monitoringEmail.templet("健康监控服务通知", params);
            Thread.sleep(HealthEntity.getInstance().getStartInterva());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        Object obj = new Object();
        log.info("获取健康数据线程启动。。。。");
        Calendar calendar = Calendar.getInstance();
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    String jsonStr = restTemplate.getForObject(HealthEntity.getInstance().getRemotHostJvm(), String.class);
                    JSONObject jsonObject = JSON.parseObject(jsonStr);
                    JSONArray measurements = jsonObject.getJSONArray("measurements");
                    if (measurements != null) {
                        double usedJvm = (((JSONObject) measurements.get(0)).getLong("value")) * 1.0 / HealthEntity.getInstance().getJvmmMaxSize();
                        log.info("当前开销比：{}", usedJvm);
                        if (usedJvm > HealthEntity.getInstance().getCast()) {
                            log.info("***##################*** >> 大于Jvm Cast设定值: {}", usedJvm);
                            if (HealthEntity.getInstance().isFlag()) {
                                exeu(obj);
                            }
                        }

                    }
                    String jsonStrCpu = restTemplate.getForObject(HealthEntity.getInstance().getRemotHostCpu(), String.class);
                    JSONObject jsonObjectCpu = JSON.parseObject(jsonStrCpu);
                    JSONArray measurementsCpu = jsonObjectCpu.getJSONArray("measurements");
                    if (measurementsCpu != null) {
                        double usedCpu = (((JSONObject) measurementsCpu.get(0)).getLong("value")) / 10.0;
                        if (usedCpu > HealthEntity.getInstance().getCastCpu()) {
                            log.info("***##################*** >> 大于CPU Cast设定值: {}", usedCpu);
                            if (HealthEntity.getInstance().isFlag()) {
                                exeu(obj);
                            }
                        }
                    }

                } catch (Exception e) {
                    log.info("error >> {}", e.getMessage());
                    if (HealthEntity.getInstance().isFlag()) {
                        exeu(obj);
                    }
                }

            }
        }, firstTime, HealthEntity.getInstance().getPeriod());
    }
}