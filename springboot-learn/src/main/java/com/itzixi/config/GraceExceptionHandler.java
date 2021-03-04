package com.itzixi.config;

import com.itzixi.config.error.MyCustomException;
import com.itzixi.utils.JSONResult;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 统一的异常拦截处理助手
 * 可以针对异常的类型进行捕获，然后返回json对象给前端（H5/IOS/安卓/小程序）
 */
@ControllerAdvice
public class GraceExceptionHandler {

    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseBody
    public JSONResult returnMaxUploadSizeException() {
        return JSONResult.errorMsg("文件上传大小不能查过500KB");
    }

    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public JSONResult returnMyException(MyCustomException e) {
        e.printStackTrace();
        return JSONResult.errorMsg(e.getMessage());
    }

}
