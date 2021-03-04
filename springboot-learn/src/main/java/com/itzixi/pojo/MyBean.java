package com.itzixi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data               // 生成get和set方法
@ToString           // 生成toString方法
@AllArgsConstructor // 生成全参数的构造函数
@NoArgsConstructor  // 生成无参数的匿名构造函数
public class MyBean {
    private String name;
    private Integer age;
    private String grade;
    private String clazz;
}
