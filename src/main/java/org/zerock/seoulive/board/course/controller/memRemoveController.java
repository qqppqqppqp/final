package org.zerock.seoulive.board.course.controller;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.course.domain.memberVO;
import org.zerock.seoulive.board.course.service.courseViewService;
import org.zerock.seoulive.board.course.service.memberService;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RequestMapping(value = "/member")
@Controller
@Log4j2
@AllArgsConstructor
public class memRemoveController {

    @Setter(onMethod_ = @Autowired)
    private memberService service;

    @GetMapping("/remove")
    public void getWithdrawal() throws Exception {
        log.info("getWithdrawal() invoked");
        }

    @PostMapping("/remove")
    public String postWithdrawal(HttpSession session, memberVO vo, RedirectAttributes rttrs) throws Exception {
        memberVO member = (memberVO)session.getAttribute("member");

        String storedPassword  = member.getPASSWORD();
        String enteredPassword  = vo.getPASSWORD();

        if(!(enteredPassword.equals(storedPassword))) {

            rttrs.addFlashAttribute("msg", false);
            return "redirect:/member/remove";
        }

        service.withdrawal(vo);

        session.invalidate();
        return "redirect:/";
    }
}


