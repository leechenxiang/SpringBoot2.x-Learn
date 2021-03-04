package com.itzixi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@Slf4j
public class AsyncTask {

    @Async
    public void doMyTask() {
        // 处理异步执行的业务
        try {
            Thread.sleep(5000);
            log.info("异步任务执行完毕~~");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
