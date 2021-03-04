package com.itzixi.config;

import com.itzixi.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      // 说明当前类为配置场景下所使用的一个组件，加上后会在springboot启动的时候被加载到容器中
/**
 * 同理 @Controller @RestController @Bean @Service @Repository @Component
 */
public class SpringBootConfig {

    @Bean("student")       // 当前类被容器扫描到以后，会被作为容器中的对象（组件）存在，如此可以在别的类中注入并且使用
    public Stu stu() {
        return new Stu("Jack", 18);
    }

}
