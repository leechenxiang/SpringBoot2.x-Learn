package com.itzixi.controller;


import com.itzixi.utils.JSONResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class StuRestController {

    @GetMapping("stu")
    public String getStuRest() {
        return "查询 - stu";
    }

    @PostMapping("stu")
    public String craeteStuRest() {
        return "创建 - stu";
    }

    @PutMapping("stu")
    public String updateStuRest() {
        return "更新 - stu";
    }

    @DeleteMapping("stu")
    public String deleteStuRest() {
        return "删除 - stu";
    }

    @PostMapping("upload")
    public JSONResult upload(MultipartFile file) throws Exception {

        String path = "/temp/" + file.getOriginalFilename();
        file.transferTo(new File(path));

        return JSONResult.ok("文件保存成功");
    }

}
