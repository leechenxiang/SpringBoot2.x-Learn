package com.itzixi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 1. 表明当前项目为SpringBoot程序，这是一个启动类，应用程序的入口
 * 2. com.xxx 为你的项目根路径，启动类需要放在根路径之下，因为他会默认扫描跟路径以及子路径之下的所有controller/service/mapper/pojo
 *    并且会扫描到springboot容器中
 */
@SpringBootApplication
@MapperScan("com.itzixi.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
