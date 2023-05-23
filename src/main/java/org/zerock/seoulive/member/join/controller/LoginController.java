package org.zerock.seoulive.member.join.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.domain.UserVO;
import org.zerock.seoulive.member.join.exception.ControllerException;
import org.zerock.seoulive.member.join.service.UserService;


@Log4j2
@NoArgsConstructor

@SessionAttributes({"__AUTH__"})    // 인증객체를 세션에 넣어줌

@RequestMapping("/member")
@Controller
public class LoginController {
    @Setter(onMethod_ = @Autowired)
    private UserService service;

    @PostMapping("/loginPost")
    String loginPost(UserDTO dto, Model model, RedirectAttributes rttrs) throws ControllerException {
        log.trace("loginPost({}, model) invoked.", dto);

        try {
            UserVO userVO = this.service.authenticate(dto);

            if (userVO != null) { // 인증성공
                model.addAttribute("__AUTH__", userVO); // Request scope

                return "redirect:/";
            } else {             // 인증실패
                rttrs.addAttribute("__RESULT__", "로그인 실패");

                return "redirect:/member/login/email";
            } // if-else
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // loginPost

} // end class