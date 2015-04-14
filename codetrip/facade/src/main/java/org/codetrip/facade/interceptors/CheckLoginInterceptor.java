package org.codetrip.facade.interceptors;

import org.codetrip.common.vo.UserVO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by RuFeng on 2015/4/14.
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 如果用户已经登录，则设置model的logined属性
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //如果是将被重定向，则不进行处理
        if (modelAndView != null && modelAndView.getViewName().startsWith("redirect:")) {
            return;
        }
        //检查用户是否已经存在
        UserVO userVO;
        if ((userVO = (UserVO) request.getSession().getAttribute("currentUser")) != null) {
            modelAndView.addObject("logined", true);
            modelAndView.addObject("nikename", userVO.getNikeName());
        }
    }
}
