package org.codetrip.facade.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by RuFeng on 2015/4/16.
 */
public class JumpTraceInterceptor extends HandlerInterceptorAdapter {

    /**
     * 记录
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getPathInfo().endsWith("login") || request.getPathInfo().endsWith("register")) {
            return true;
        }
        request.getSession().setAttribute("preRequestPath", request.getPathInfo());
        return true;
    }
}
