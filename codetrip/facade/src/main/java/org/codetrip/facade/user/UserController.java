package org.codetrip.facade.user;

import org.codetrip.common.enumerate.Gender;
import org.codetrip.common.enumerate.Nationality;
import org.codetrip.common.enumerate.Role;
import org.codetrip.common.vo.UserVO;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by RuFeng on 2015/2/11.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * jump to register
     * @return String
     * */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerPage() {
        return "user/register";
    }

    /**
     * login page
     * @return String
     * */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "user/login";
    }

    /**
     * do register
     * @param request
     * @param model
     * */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerAction(HttpServletRequest request, Model model) {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String nikename = request.getParameter("nikename");
        String publication = request.getParameter("publication");

        UserModel user = new UserModel();
        user.setRegisteDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis()));
        user.setNikeName(nikename);
        user.setSex(Gender.MALE);
        user.setAge(0);
        user.setEmail(email);
        user.setRole(Role.MEMBER);
        user.setNationality(Nationality.CHINA);
        user.setPassword(password);

        if (publication != null && publication.equals("true")) {
            user.setPublication(Boolean.TRUE);
        } else {
            user.setPublication(Boolean.FALSE);
        }

        UserVO userVO = userService.registe(user);
        if (userVO.isRegisteSuccess()) {
            if (userVO.isLogined()) {
                request.getSession().setAttribute("currentUser", userVO);
                String preRequestPath = (String)request.getSession().getAttribute("preRequestPath");
                if (preRequestPath == null) {
                    return "redirect:/index";
                } else {
                    return "redirect:" + preRequestPath;
                }
            } else {
                model.addAttribute("registefault", true);
                return "user/register";
            }
        } else {
            model.addAttribute("registefault", true);
            return "user/register";
        }
    }

    /**
     * login
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginAction(HttpServletRequest request, Model model) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserModel user = new UserModel();
        user.setEmail(email);
        user.setPassword(password);
        UserVO userVO = userService.login(user);
        if (userVO.isLogined()) {
            request.getSession().setAttribute("currentUser", userVO);
            String preRequestPath = (String)request.getSession().getAttribute("preRequestPath");
            if (preRequestPath == null) {
                return "redirect:/index";
            } else {
                return "redirect:" + preRequestPath;
            }
        } else {
            model.addAttribute("loginFault", true);
            return "user/login";
        }
    }

    /**
     * logout
     *
     * @param request
     * @return String
     */
    @RequestMapping(value = "logout")
    public String logoutAction(HttpServletRequest request) {
        request.getSession().removeAttribute("currentUser");
        return "redirect:/index";
    }
}
