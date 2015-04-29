package org.codetrip.facade.contest;

import org.codetrip.common.vo.ContestVO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.contest.ContestService;
import org.codetrip.service.contestproblem.ContestProblemService;
import org.codetrip.service.participator.ParticipatorService;
import org.codetrip.service.problem.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by RuFeng on 2015/4/21.
 */
@Controller
@RequestMapping(value = "contests")
public class ContestsController {

    @Autowired
    private ContestService contestService;

    @Autowired
    private ParticipatorService participatorService;

    @Autowired
    private ContestProblemService contestProblemService;

    /**
     * 列出所有比赛
     *
     * @param model
     * */
    @RequestMapping(value = "/show")
    public String Contestpage(HttpServletRequest request, Model model) {

        UserVO user = (UserVO)request.getSession().getAttribute("currentUser");

        List<ContestVO> contestVOList = contestService.listAllPublicContests();

        for (ContestVO vo : contestVOList) {
            if (user != null) {
                vo.setAccessable(participatorService.checkParticipator(user.getId(), vo.getId()));
            } else {
                vo.setAccessable(false);
            }
        }

        model.addAttribute("contests", contestVOList);

        return "contests/contests";
    }

    /**
     * 查看比赛
     *
     * @param model
     * @param contestId
     * @return String
     * */
    @RequestMapping(value = "/view/{CID}")
    public String viewContestPage(Model model, @PathVariable(value = "CID")Long contestId) {
        List<ProblemVO> problemVOs = contestProblemService.listContestProblems(contestId);
        ContestVO contestVO = contestService.listSpecificContest(contestId);
        model.addAttribute("problems", problemVOs);
        model.addAttribute("title", contestVO.getTitle());
        return "contests/viewcontest";
    }
}
