package com.micloud.actuator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * <h1>  </h1>
 *
 * @author 风清扬
 * @date 2020/12/25 15:13
 */
@Service
@Slf4j
public class PorcessService {


    public  Boolean getRedisIsOk(String url, int port,String password) {
        Boolean result = false;
        Jedis jedis = null;
        try {
            //连接本地Redis服务
            jedis = new Jedis(url, port);
            jedis.auth(password);//密码
            String ping = jedis.ping();
            if (ping.equalsIgnoreCase("PONG")) {
                log.info("redis缓存有效！" + ping);
                result = true;
            }
        } catch (Exception e) {
            log.info("redis缓存失败！{}",e.getMessage());
            result = false;
        }finally {
            if(jedis != null){
                jedis.close(); // 释放连接资源
            }
        }
        return result;
    }

}
