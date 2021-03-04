package com.itzixi.config.error;

/**
 * 优雅的处理异常，可以当做一个异常的工具类去调用并且执行异常返回
 */
public class GraceException {

    public static void display(String errorMsg) {
        throw  new MyCustomException(errorMsg);
    }

}
