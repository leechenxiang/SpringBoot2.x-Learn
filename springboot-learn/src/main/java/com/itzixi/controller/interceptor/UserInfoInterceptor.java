package com.itzixi.controller.interceptor;

import com.itzixi.config.error.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求，访问controller之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userId = request.getHeader("userId");
        String userToken = request.getHeader("userToken");

        // 假设真实情况下，userId和userToken分别为1001和abc
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userToken)) {
            log.error("用户请求非法！");
            GraceException.display("优雅的异常：用户请求非法！");
            return false;
        }

        if (!userId.equals("1001") || !userToken.equals("abc")) {
            log.error("用户请求非法！");
            GraceException.display("优雅的异常：用户请求非法！");
            return false;
        }

        /**
         * false: 请求被拦截
         * true: 请求通过校验，可以放行，请求可以继续到达目标controller去处理业务
         */
        return true;
    }

    /**
     * 请求访问到controller之后，渲染视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求访问到controller之后，渲染视图之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
