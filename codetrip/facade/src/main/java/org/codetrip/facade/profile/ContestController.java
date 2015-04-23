package org.codetrip.facade.profile;

import org.codetrip.common.vo.ContestVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.service.contest.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/4/16.
 */
@Controller
@RequestMapping(value = "profile")
public class ContestController {
    private final static Logger LOG = Logger.getLogger(ContestController.class.getName());

    @Autowired
    private ContestService contestService;

    /**
     * 添加比赛界面
     *
     * @param request
     * @param model
     * */
    @RequestMapping(value = "/contests")
    public String contestPage(HttpServletRequest request, Model model) {
        UserVO userVO = (UserVO)request.getSession().getAttribute("currentUser");
        if (userVO != null) {
            List<ContestVO> contestVOList = contestService.listUsersContests(userVO.getId());
            model.addAttribute("contests", contestVOList);
        } else {
            LOG.warning("not logined when list user's contests");
        }
        return "profile/contests";
    }
}
