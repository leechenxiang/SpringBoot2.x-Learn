package com.itzixi.config.error;

/**
 * 自定义异常
 * 目的：同一处理异常
 *      便于解耦，service和controller错误的解耦，不会被service返回的类型而限制
 */
public class MyCustomException extends RuntimeException {

    public MyCustomException(String errorMsg) {
        super(errorMsg);
    }

}
