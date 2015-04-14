package org.codetrip.facade.interceptors;

import org.codetrip.common.vo.UserVO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by RuFeng on 2015/4/14.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    /**
     * 在访问前进行权限检查
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserVO userVO = (UserVO)request.getSession().getAttribute("currentUser");

        if (userVO == null) {
            return false;
        } else {
            return true;
        }
    }
}
