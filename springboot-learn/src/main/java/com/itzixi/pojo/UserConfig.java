package com.itzixi.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component         // 把当前配置作为组件被容器扫描到以后放入到上下文对象中
@ConfigurationProperties(prefix = "user")
@PropertySource(value = "classpath:UserConfig.properties", encoding = "utf-8")
public class UserConfig {
    private String name;
    private Integer age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
