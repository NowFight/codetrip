package org.codetrip.facade.profile;

import org.codetrip.common.util.DateUtil;
import org.codetrip.common.util.Numeric;
import org.codetrip.common.vo.ContestVO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.model.contest.ContestModel;
import org.codetrip.service.contest.ContestService;
import org.codetrip.service.contestproblem.ContestProblemService;
import org.codetrip.service.problem.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/4/16.
 */
@Controller
@RequestMapping(value = "profile")
public class AddContestController {

    private final static Logger LOG = Logger.getLogger(AddContestController.class.getName());

    @Autowired
    private ContestService contestService;

    @Autowired
    private ProblemService problemService;

    @Autowired
    private ContestProblemService contestProblemService;

    /**
     * 创建比赛页面
     *
     * @return String
     * */
    @RequestMapping(value = "addcontest", method = RequestMethod.GET)
    public String addContestPage() {
        return "profile/addcontest";
    }

    /**
     * 添加比赛
     *
     * @param request
     * @return String
     * */
    @RequestMapping(value = "addcontest", method = RequestMethod.POST)
    public String addContestAction(HttpServletRequest request) throws Exception {
        String title = request.getParameter("title");
        String startTime = request.getParameter("starttime");
        String endTime = request.getParameter("endtime");

        SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd HH:mm");
        String formatedStartTime = sdf.format(DateUtil.DateParser(startTime, "MM/dd/yyyy h:mm").getTime());
        String formatedEndTime = sdf.format(DateUtil.DateParser(endTime, "MM/dd/yyyy h:mm").getTime());
        UserVO user = (UserVO)request.getSession().getAttribute("currentUser");
        if (user != null) {
            ContestModel contest = new ContestModel();
            contest.setTitle(title);
            contest.setUserId(user.getId());
            contest.setPrivatable(Boolean.FALSE);
            contest.setStartTime(formatedStartTime);
            contest.setEndTime(formatedEndTime);
            contest.setCreateDate(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(System.currentTimeMillis()));
            contestService.addContest(contest);
        } else {
            LOG.warning("not logined when add contest");
        }
        return "redirect:/profile/contests";
    }

    /**
     * 添加比赛题目页面
     *
     * @param model
     * @param contestId
     * @return String
     * */
    @RequestMapping(value = "addcontest/{CID}/addproblem")
    public String addContestProblem(Model model, @PathVariable(value = "CID") Long contestId) {
        List<ProblemVO> problemVOs = problemService.listAllProblems();
        List<ProblemVO> inContestProblemVOs = contestProblemService.listContestProblems(contestId);
        model.addAttribute("inContestProblems", inContestProblemVOs);
        model.addAttribute("problems", problemVOs);
        model.addAttribute("contestId", contestId);
        return "profile/addcontestproblems";
    }

    /**
     * 添加比赛题目
     *
     * @param request
     * */
    @RequestMapping(value = "addcontest/addproblem", method = RequestMethod.POST)
    public String addContestProblemAction(HttpServletRequest request) {
        String problemIds = request.getParameter("problemIds");
        String contestId = request.getParameter("contestId");
        String[] pList = problemIds.split(";");
        List<Long> pIds = new ArrayList<Long>();
        for (String item : pList) {
            if (Numeric.isInteger(item)) {
                pIds.add(Long.parseLong(item));
            } else {
                LOG.warning("problem id is not a number");
            }
        }
        if (Numeric.isInteger(contestId)) {
            System.out.println(pIds);
            contestProblemService.batchAddProblem(Long.parseLong(contestId), pIds);
        } else {
            LOG.warning("contest id : " + contestId + " is not a number");
        }
        return "redirect:/profile/contests";
    }
}
