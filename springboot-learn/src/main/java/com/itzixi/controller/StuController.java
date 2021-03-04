package com.itzixi.controller;


import com.itzixi.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController("stu")
@RequestMapping("stu")
@Slf4j
public class StuController {

    @GetMapping("{userId}/getSingleStu")
    public String getSingleStu(@PathVariable("userId") String userId,
                               @RequestParam Integer id,
                               @RequestParam String name) {

        /**
         * @RequestParam：获得url中的请求参数，参数变量名一致，可以省略该注解
         *
         */

        log.info("id=" + id);
        log.info("name=" + name);

        log.info("userId=" + userId);

        return "查询 - stu";
    }

    @GetMapping("getListStu")
    public String getListStu() {
        return "查询 - stu 列表";
    }

    @PostMapping("createStu")
    public Object createStu(@RequestBody Map<String, Object> map,
                            @RequestHeader("token") String token,
                            @CookieValue("scores") Integer scores,
                            HttpServletRequest request) {

        log.info("map=" + map.toString());
        log.info("token=" + token);
        log.info("scores=" + scores);

        String headerToken = request.getHeader("token");
        log.info("headerToken=" + headerToken);

//        return "创建 - stu";
        return JSONResult.errorMsg("创建学生出错，请联系管理员~");
    }

    @PostMapping("updateStu")
    public String updateStu() {
        return "更新 - stu";
    }

    @PostMapping("deleteStu")
    public String deleteStu() {
        return "删除 - stu";
    }
}
