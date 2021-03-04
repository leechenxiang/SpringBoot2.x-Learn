package com.itzixi.test;

import com.itzixi.pojo.Teacher;
import com.itzixi.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

//@SpringBootTest         // 表示当前会被springboot加载为测试类
//public class MyTests {
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @Test
//    public void testSaveTeacher() {
//        String tid = UUID.randomUUID().toString();
//
//        Teacher teacher = new Teacher();
//        teacher.setId(tid);
//        teacher.setName("Jack");
//        teacher.setAge(20);
//        teacher.setSex("男");
//        teacherService.saveTeacher(teacher);
//    }
//
//
//}
