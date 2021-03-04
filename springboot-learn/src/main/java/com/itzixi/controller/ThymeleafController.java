package com.itzixi.controller;


import com.itzixi.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("thyme")
public class ThymeleafController {

    @GetMapping("hello")
    public String hello(Model model, HttpServletRequest request) {

        // 输出字符串
        String stranger = "Jack";
        model.addAttribute("there", stranger);

        // 输出格式化的日期
        Date birthDay = new Date();
        model.addAttribute("birthDay", birthDay);

        // sex 性别 用于判断
        Integer sex = 2;
        model.addAttribute("sex", sex);

        // list
        List<String> myList = new ArrayList<>();
        myList.add("1001");
        myList.add("1002");
        myList.add("1003");
        model.addAttribute("myList", myList);

        // map
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("id", "30033");
        myMap.put("age", 18);
        myMap.put("sex", "boy");
        myMap.put("name", "风间影月");
        model.addAttribute("myMap", myMap);

        request.setAttribute("enName", "abcxyz");
        request.getSession().setAttribute("userToken", UUID.randomUUID().toString());

        return "teacher";
    }

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("createHTML")
    @ResponseBody
    public JSONResult createHTML(Model model, HttpServletRequest request) throws Throwable {

        // 输出字符串
        String stranger = "Jack";

        // 输出格式化的日期
        Date birthDay = new Date();

        // sex 性别 用于判断
        Integer sex = 2;

        // list
        List<String> myList = new ArrayList<>();
        myList.add("1001");
        myList.add("1002");
        myList.add("1003");

        // map
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("id", "30033");
        myMap.put("age", 18);
        myMap.put("sex", "boy");
        myMap.put("name", "风间影月");


//        request.setAttribute("enName", "abcxyz");
//        request.getSession().setAttribute("userToken", UUID.randomUUID().toString());


        // 获得thymeleaf的上下文对象，存入模板中所需要进行渲染的数据
        Context context = new Context();
        context.setVariable("there", stranger);
        context.setVariable("birthDay", birthDay);
        context.setVariable("sex", sex);
        context.setVariable("myList", myList);
        context.setVariable("myMap", myMap);

        // 定义html生成的保存的目录
        String htmlTarget = "/temp";
        // 判断目标输出的文件夹路径是否存在，如果没有则创建
        File htmlDic = new File(htmlTarget);
        if (!htmlDic.exists()) {
            htmlDic.mkdirs();
        }

        // 生成内容并且输出到html文件
        Writer out = new FileWriter(htmlTarget + "/teacher.html");
        templateEngine.process("teacher", context, out);
        out.close();

        return JSONResult.ok("HTML生成成功~~");
    }

}
