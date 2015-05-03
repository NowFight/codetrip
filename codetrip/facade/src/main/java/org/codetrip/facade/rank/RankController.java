package org.codetrip.facade.rank;

import org.codetrip.common.vo.*;
import org.codetrip.service.contestproblem.ContestProblemService;
import org.codetrip.service.participator.ParticipatorService;
import org.codetrip.service.rank.RankService;
import org.codetrip.service.statistic.ProblemStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuFeng on 2015/4/29.
 */
@Controller
@RequestMapping(value = "rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @Autowired
    private ContestProblemService contestProblemService;

    /**
     * rank页面
     * */
    @RequestMapping(value = "rankpage/{CID}")
    public String rankPage(Model model, @PathVariable(value = "CID") Long contestId) {
        List<ProblemVO> problemVOs = contestProblemService.listContestProblems(contestId);
        List<RankVO> rankVOs = rankService.listContestRank(contestId);
        model.addAttribute("ranks", rankVOs);
        model.addAttribute("size", problemVOs.size() + 1);
        return "contests/rank";
    }
}
