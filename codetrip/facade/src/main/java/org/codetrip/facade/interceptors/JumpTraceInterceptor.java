package org.codetrip.facade.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/4/16.
 */
public class JumpTraceInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOG = Logger.getLogger(JumpTraceInterceptor.class.getName());

    /**
     * 记录用户的请求路径
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getPathInfo().endsWith("login") || request.getPathInfo().endsWith("register") ||
                request.getPathInfo().startsWith("/resources") || request.getPathInfo().startsWith("/resources")) {
            return true;
        }
        request.getSession().setAttribute("preRequestPath", request.getPathInfo());
        LOG.info(String.format("[%s] request path : %s",
                new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()),
                request.getPathInfo()));
        return true;
    }
}
