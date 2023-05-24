package org.zerock.seoulive.member.join.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.service.MailSendService;
import org.zerock.seoulive.member.join.service.UserService;

import java.util.Objects;


@Log4j2
@NoArgsConstructor

@RequestMapping("/member/join")
@Controller
public class UserController {
    @Setter(onMethod_ = @Autowired)
    private UserService service;
    @Setter(onMethod_ = @Autowired)
    private MailSendService mailService;


    @GetMapping("/main")
    void joinMain() {   // 단순 등록화면 요청
        log.trace("joinMain() invoked.");

    } // joinMain

    @GetMapping("/register")
    void register() {   // 단순 등록화면 요청
        log.trace("register() invoked.");

    } // register

    @PostMapping(
            value = "/register",
            params = {"email", "password", "birthDate", "gender", "nickName", "introduction"}
    )
    String register(UserDTO dto) throws Exception {
        log.trace("register({}) invoked.", dto);

        try {
            Objects.requireNonNull(dto);
            this.service.register(dto);

            return "redirect:/member/join/register";
        } catch(Exception e) {
            throw new Exception(e);
        } // try-catch
    } // register

    //이메일 인증
    @GetMapping("/register/mailCheck")
    @ResponseBody
    public String mailCheck(String email) {
        log.trace("mailCheck({}) invoked.", email);

        return mailService.joinEmail(email);
    } // mailCheck


} // end class
