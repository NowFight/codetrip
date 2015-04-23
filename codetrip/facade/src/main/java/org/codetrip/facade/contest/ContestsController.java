package org.codetrip.facade.contest;

import org.codetrip.common.vo.ContestVO;
import org.codetrip.service.contest.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by RuFeng on 2015/4/21.
 */
@Controller
@RequestMapping(value = "contests")
public class ContestsController {

    @Autowired
    private ContestService contestService;

    /**
     * 列出所有比赛
     *
     * @param model
     * */
    @RequestMapping(value = "/show")
    public String Contestpage(Model model) {

        List<ContestVO> contestVOList = contestService.listAllPublicContests();

        model.addAttribute("contests", contestVOList);

        return "contests/contests";
    }
}
