package com.itzixi.controller;


import com.itzixi.pojo.Teacher;
import com.itzixi.pojo.bo.TeacherBO;
import com.itzixi.service.TeacherService;
import com.itzixi.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("teacher")
@Slf4j
public class TeacherController {
    @Autowired
    public TeacherService teacherService;


    @GetMapping("{tid}")
    public JSONResult queryTeacherById(@PathVariable("tid") String tid) {
        Teacher teacher = teacherService.queryTeacherById(tid);
        return JSONResult.ok(teacher);
    }

    @GetMapping("getList")
    public JSONResult getList() {
        List<Teacher> teacherList = teacherService.queryTeacherByCondition("lee", 28, "男");
        return JSONResult.ok(teacherList);
    }

    @GetMapping("getListPaged")
    public JSONResult getListPaged(Integer page, Integer pageSize) {
        List<Teacher> teacherList = teacherService.queryTeacherPaged("lee", page, pageSize);
        return JSONResult.ok(teacherList);
    }

    @PostMapping("update")
    public JSONResult update(@RequestBody TeacherBO teacherBO) {

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherBO, teacher);

        teacherService.updateTeacher(teacher);
        return JSONResult.ok("修改成功");
    }

    @PostMapping("create")
    public JSONResult create(@Valid @RequestBody TeacherBO teacherBO, BindingResult result) {

        // 判断BindingResult中是否包含一些错误的信息，如果有错误，则直接返回给前端
        if (result.hasErrors()) {
            Map<String, String> errorMap = getErrors(result);
            return JSONResult.errorMap(errorMap);
        }


        String tid = UUID.randomUUID().toString();

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherBO, teacher);
        teacher.setId(tid);
//        teacher.setName("Jack");
//        teacher.setAge(20);
//        teacher.setSex("男");
        teacherService.saveTeacher(teacher);

        return JSONResult.ok();
    }

    /**
     * 获取BO业务对象的错误
     * @param result
     */
    public Map<String, String> getErrors(BindingResult result) {
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            // 获得检验发送错误的某个属性名称
            String field = error.getField();
            // 获得该属性发生错误的信息
            String msg = error.getDefaultMessage();
            errorMap.put(field, msg);
        }
        return errorMap;
    }


    @DeleteMapping("delete")
    public JSONResult deleteStu() {

        Teacher teacher = new Teacher();
        teacher.setName("lee");
        teacher.setAge(28);

        teacherService.deleteTeacher(teacher);

        return JSONResult.ok("删除成功");
    }

    @PostMapping("testTrans")
    public JSONResult testTrans() {
        teacherService.testTrans();
        return JSONResult.ok("模拟异常下的事务回滚");
    }

    @GetMapping("getTeacherByIdCustomSQL")
    public JSONResult getTeacherByIdCustomSQL(String id) {
        return JSONResult.ok(teacherService.getTeacherByIdCustomSQL(id));
    }

}
