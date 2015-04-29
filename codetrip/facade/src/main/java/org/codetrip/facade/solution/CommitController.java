package org.codetrip.facade.solution;

import org.codetrip.common.enumerate.JudgeResult;
import org.codetrip.common.enumerate.Language;
import org.codetrip.common.vo.ContestProblemVO;
import org.codetrip.common.vo.ParticipantVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.dao.contestproblem.ContestProblemDao;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.codetrip.model.participant.ParticipantModel;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.solution.SolutionModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.contestproblem.ContestProblemService;
import org.codetrip.service.participator.ParticipatorService;
import org.codetrip.service.problem.ProblemService;
import org.codetrip.service.solution.SolutionService;
import org.codetrip.service.statistic.ProblemStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/2/21.
 */
@Controller
@RequestMapping(value = "commit")
public class CommitController {

    private static final Logger LOG = Logger.getLogger(CommitController.class.getName());

    @Autowired
    private SolutionService solutionService;

    @Autowired
    private ContestProblemService contestProblemService;

    @Autowired
    private ParticipatorService participatorService;

    /**
     * 提交代码
     *
     * @param request
     * @param model
     * @param problemId
     * @return String
     * */
    @RequestMapping(value = "/pid/{pid}", method = RequestMethod.POST)
    public String doCommit(HttpServletRequest request, Model model, @PathVariable(value = "pid")Long problemId) {

        UserVO user = (UserVO)request.getSession().getAttribute("currentUser");

        if (user != null) {
            String codeContent = request.getParameter("codecontext");
            String language = request.getParameter("language");

            SolutionModel solution = new SolutionModel();
            solution.setCodeContext(codeContent);
            solution.setProblemId(problemId);
            solution.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis()));
            solution.setUserId(user.getId());
            solution.setLanguage(getLanguageType(language));
            solution.setResult(JudgeResult.QUEUE);

            solutionService.commit(solution);
        } else {
            LOG.warning("user is null when commit");
        }

        return "redirect:/status/";
    }

    /**
     * 提交比赛的题目代码
     *
     * @param request
     * @param model
     * @param contestProblemId
     * @return String
     * */
    @RequestMapping(value = "/contest/{CPID}", method = RequestMethod.POST)
    public String doContestCommit(HttpServletRequest request, Model model, @PathVariable(value = "CPID") Long contestProblemId) {
        UserVO user = (UserVO)request.getSession().getAttribute("currentUser");

        if (user != null) {

            ContestProblemVO vo = contestProblemService.getContestProblem(contestProblemId);
            ParticipantVO pvo = participatorService.getParticipator(user.getId(), vo.getContestId());

            if (vo != null && pvo != null) {
                request.getSession().setAttribute("currentTeam", pvo);
                String codeContent = request.getParameter("codecontext");
                String language = request.getParameter("language");

                SolutionModel solution = new SolutionModel();
                solution.setCodeContext(codeContent);

                solution.setTeamId(pvo.getId());
                solution.setProblemId(vo.getProblemId());
                solution.setContestId(vo.getContestId());
                solution.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis()));
                solution.setLanguage(getLanguageType(language));
                solution.setResult(JudgeResult.QUEUE);

                solutionService.commit(solution);
            }
        } else {
            LOG.warning("user is null when commit");
        }

        return "redirect:/status/";
    }

    /**
     * 获得language类型
     *
     * @param language
     * @return Language
     * */
    private Language getLanguageType(String language) {
        if (language.equals("gcc")) {
            return Language.C;
        }
        else if(language.equals("g++")) {
            return Language.CPP;
        }
        else if (language.equals("java")) {
            return Language.JAVA;
        } else {
            LOG.warning("unexpected language type " + language);
            return Language.UNKNOWN;
        }
    }
}
