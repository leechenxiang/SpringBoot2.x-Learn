package com.itzixi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//@Configuration          // 1. 标记配置类，放入到springboot容器中
//@EnableScheduling       // 2. 开启定时任务的注解
@Slf4j
public class MyTask {

    // 3. 添加定时任务，注明定时任务的表达式
    @Scheduled(cron = "*/5 * * * * ?")
    public void displayMyTask() {
        log.info("当前正在执行定时任务，当前的时间为：" + LocalDateTime.now());
    }

//    常用的定时任务表达式：
//    每隔5秒执行一次：*/5 * * * * ?
//    每隔1分钟执行一次：0 */1 * * * ?
//    每天23点执行一次：0 0 23 * * ?
//    每天凌晨1点执行一次：0 0 1 * * ?
//    每月1号凌晨1点执行一次：0 0 1 1 * ?
//    每月最后一天23点执行一次：0 0 23 L * ?
//    每周星期天凌晨1点实行一次：0 0 1 ? * L
//    在26分、29分、33分执行一次：0 26,29,33 * * * ?
//    每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?

}
