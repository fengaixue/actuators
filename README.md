# actuators
 监控
2020年9月18日完成初始化项目

HealthEntity：参数实体类，单例模式，可通过API获取/设置当前启动间隔、BAT路径等信息

MonitoringManager：启动线运行类，内部启动线程，线程内部运行定时器进行监控


server:
  port: 2001 服务端口号
spring:
  application:
    name: AdminUi-Server
logging:
  config: classpath:logback-spring.xml
log2path: D:/mine/logs2  ：日志路径