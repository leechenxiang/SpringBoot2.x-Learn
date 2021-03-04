package com.itzixi.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ServiceLogAOP {

    /**
     * AOP通知：
     * 1. 前置通知
     * 2. 后置通知
     * 3. 环绕通知
     * 4. 异常通知
     * 5. 最终通知
     */
    @Around("execution(* com.itzixi.service.impl..*.*(..))")
    public Object recordTimeOfService(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("===== 开始执行 {}.{} =====", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());

        // 1. 记录service的方法执行之前的时间
        long start = System.currentTimeMillis();

        // 2. 开始执行service的方法
        Object result = joinPoint.proceed();

        // 3. 记录service的方法执行之后的时间
        long end = System.currentTimeMillis();
        // 4. 得到service的方法执行的时间差
        long takeTime = end - start;

        // 5. 根据时间差来进行判断，并且打印日志的输出到控制台
        if (takeTime > 3000) {
            log.error("当前执行时间耗时太久了，为{}毫秒", takeTime);
        } else if (takeTime > 2000) {
            log.warn("当前执行时间耗时稍微有点长，应该后期考虑优化，为{}毫秒", takeTime);
        } else {
            log.info("当前执行时间耗时为{}毫秒", takeTime);
        }

        return result;
    }

}
