package org.codetrip.facade.contest;

import org.codetrip.common.enumerate.ContestStatus;
import org.codetrip.common.vo.ContestVO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.service.contestproblem.ContestProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RuFeng on 2015/4/28.
 */
@Controller
@RequestMapping(value = "contest/problem")
public class ContestProblemController {

    @Autowired
    ContestProblemService contestProblemService;

    /**
     * 题目页面
     *
     * */
    @RequestMapping(value = "view/{CPID}")
    public String viewContestProblem(HttpServletRequest request, Model model,
                                     @PathVariable(value = "CPID") Long contestProblemId) {
        ProblemVO vo = contestProblemService.getProblem(contestProblemId);
        ContestVO cvo = contestProblemService.getContest(contestProblemId);
        if (cvo.getStatus().equals(ContestStatus.DONE)) {
            model.addAttribute("done", true);
        } else {
            model.addAttribute("done", false);
        }
        vo.setContestProblemId(contestProblemId);
        model.addAttribute("problem", vo);
        model.addAttribute("in_contest", true);
        model.addAttribute("contest_id", cvo.getId());
        return "contests/contestproblem";
    }
}
