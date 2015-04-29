package org.codetrip.facade.contest;

import org.codetrip.common.vo.ParticipantVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.model.participant.ParticipantModel;
import org.codetrip.service.participator.ParticipatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by RuFeng on 2015/4/28.
 */
@Controller
@RequestMapping(value = "contest/participant")
public class RegisterContestController {

    @Autowired
    private ParticipatorService participatorService;

    /**
     * 注册比赛
     *
     * @return String
     * */
    @RequestMapping(value = "{CID}")
    public String registerContestPage(HttpServletRequest request, Model model, @PathVariable(value = "CID") Long contestId) {
        UserVO user = (UserVO)request.getSession().getAttribute("currentUser");

        List<ParticipantVO> participantVOs = participatorService.listParticipators(contestId);
        model.addAttribute("participators", participantVOs);
        model.addAttribute("contestId", contestId);
        if (user == null || participatorService.checkParticipator(user.getId(), contestId)) {
            model.addAttribute("alreadyregister", true);
        } else {
            model.addAttribute("alreadyregister", false);
        }
        return "contests/participator";
    }

    /**
     * 注册个人赛
     * */
    @RequestMapping(value = "{CID}/register")
    public String registerContestAction(HttpServletRequest request, Model model, @PathVariable(value = "CID") Long contestId) {
        UserVO user = (UserVO)request.getSession().getAttribute("currentUser");
        if (user == null) {
            return "redirect:/user/login";
        }
        participatorService.registerContest(contestId, user.getId(), user.getNikeName());
        List<ParticipantVO> participantVOs = participatorService.listParticipators(contestId);
        model.addAttribute("participators", participantVOs);
        model.addAttribute("contestId", contestId);
        model.addAttribute("alreadyregister", true);
        return "contests/participator";
    }
}
