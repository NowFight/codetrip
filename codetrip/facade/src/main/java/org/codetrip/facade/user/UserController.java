package org.codetrip.facade.user;

import org.codetrip.model.user.UserModel;
import org.codetrip.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by RuFeng on 2015/2/11.
 */
@Controller("UserController")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * jump to register
     * @param model
     * @return String
     * */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String jumpToRegister(Model model) {
        return "register";
    }

    /**
     * do register
     * @param request
     * @param model
     * */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(HttpServletRequest request, Model model) {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String nikename = request.getParameter("nikename");
        String sex = request.getParameter("sex");
        String nationality = request.getParameter("nationality");
        String publicInfo = request.getParameter("publicinfo");
        if (publicInfo == null)
            publicInfo = "NO";
        int year = Integer.parseInt(request.getParameter("year"));

        int age = Calendar.getInstance().get(Calendar.YEAR) - year + 1;
        String registerDate = new Date().toString();

        UserModel user = new UserModel();
        user.setRegisterDate(registerDate);
        user.setNikeName(nikename);
        user.setSex(sex);
        user.setAge(age);
        user.setEmail(email);
        user.setRole("MEMBER");
        user.setNationality(nationality);
        user.setPassword(password);
        user.setPublicInfo(publicInfo);

        if (userService.queryUserByEmail(user.getEmail()) == null) {
            if (userService.insertUser(user)) {
                user = userService.queryUserByEmailAndPassword(user.getEmail(), user.getPassword());
                request.getSession().setAttribute("currentUser", user);
                return "redirect:/index";
            } else {
                model.addAttribute("registefault", true);
                return "register";
            }
        } else {
            model.addAttribute("registefault", true);
            return "register";
        }
    }

    /**
     * login
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserModel user = userService.queryUserByEmail(email);
        if (user != null) {
            user = userService.queryUserByEmailAndPassword(email, password);
            if (user != null) {
                request.getSession().setAttribute("currentUser", user);
                return "redirect:/index";
            } else {
                //密码错误
                model.addAttribute("loginFault", true);
                model.addAttribute("passwordError", true);
                return "index";
            }
        } else {
            //用户名错误
            model.addAttribute("loginFault", true);
            model.addAttribute("usernameError", true);
            return "index";
        }
    }

    /**
     * logout
     *
     * @param model
     * @param request
     * @return String
     */
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().removeAttribute("currentUser");
        return "redirect:/index";
    }
}
