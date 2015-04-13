package org.codetrip.facade;

import org.codetrip.common.vo.UserVO;
import org.codetrip.model.user.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RuFeng on 2015/2/11.
 */
@Controller("HomePageController")
public class HomePageController {
    /**
     * Home Page
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = {"/", "/index"})
    public String homePage(HttpServletRequest request, Model model) {
        UserVO user = (UserVO) request.getSession().getAttribute("currentUser");
        if (user != null) {
            model.addAttribute("logined", true);
            model.addAttribute("nikename", user.getNikeName());
        }
        return "index";
    }
}
