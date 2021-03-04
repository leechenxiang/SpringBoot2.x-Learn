package com.itzixi.controller;


import com.itzixi.pojo.MyBean;
import com.itzixi.pojo.Stu;
import com.itzixi.pojo.Teacher;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("free")
public class FreemarkerController {

    @GetMapping("hello")
    public String hello(Model model) {

        // 输出字符串
        String stranger = "风间影月";
        model.addAttribute("there", stranger);

        // 输出对象
        Teacher teacher = new Teacher();
        teacher.setId("10011");
        teacher.setName("Jack");
        teacher.setAge(17);
        teacher.setSex("0");    // 0:女 1:男
//        teacher.setBirthday(new Date());
//        teacher.setAmount(10000.88f);
//        teacher.setHaveChild(false);
//        teacher.setStu(new Stu("Lilei", 16));
        model.addAttribute("teacher", teacher);

        Teacher teacher1 = new Teacher();
        teacher1.setId("1002");
        teacher1.setName("王五");
        teacher1.setAge(16);


        // 构建一个list输出
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher);
        teacherList.add(teacher1);
        model.addAttribute("teacherList", teacherList);


        // 构建一个map输出
        Map<String, Teacher> tMap = new HashMap<>();
        tMap.put("t1", teacher);
        tMap.put("t2", teacher1);
        model.addAttribute("tMap", tMap);

        // 返回的是freemarker的模板所在目录位置的后缀名匹配，在yml中配置的
        // 匹配的是 *.ftl
        return "stu";
    }

    @GetMapping("createHTML")
    @ResponseBody
    public String createHTML(Model model) throws Exception {

        // 输出字符串
        String stranger = "风间影月";
        model.addAttribute("there", stranger);

        // 输出对象
        Teacher teacher = new Teacher();
        teacher.setId("10011");
        teacher.setName("Jack");
        teacher.setAge(17);
        teacher.setSex("0");    // 0:女 1:男
//        teacher.setBirthday(new Date());
//        teacher.setAmount(10000.88f);
//        teacher.setHaveChild(false);
//        teacher.setStu(new Stu("Lilei", 16));
        model.addAttribute("teacher", teacher);

        Teacher teacher1 = new Teacher();
        teacher1.setId("1002");
        teacher1.setName("王五");
        teacher1.setAge(16);


        // 构建一个list输出
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher);
        teacherList.add(teacher1);
        model.addAttribute("teacherList", teacherList);


        // 构建一个map输出
        Map<String, Teacher> tMap = new HashMap<>();
        tMap.put("t1", teacher);
        tMap.put("t2", teacher1);
        model.addAttribute("tMap", tMap);

        // 定义html生成的保存的目录
        String htmlTarget = "/temp";

        // 准备配置freemarker
        // 声明配置类
        Configuration cfg = new Configuration(Configuration.getVersion());
        // 定义freemarker的目标所要加载的位置
        String classpath = this.getClass().getResource("/").getPath();
        cfg.setDirectoryForTemplateLoading(new File(classpath + "templates/ftl"));

        // 加载ftl模板
        Template template = cfg.getTemplate("stu.ftl", "utf-8");

        // 判断目标输出的文件夹路径是否存在，如果没有则创建
        File htmlDic = new File(htmlTarget);
        if (!htmlDic.exists()) {
            htmlDic.mkdirs();
        }

        // 生成内容并且输出到html文件
        Writer out = new FileWriter(htmlTarget + "/stu.html");
        template.process(model, out);
        out.close();

        return "OK";
    }

}
