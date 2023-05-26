package org.zerock.seoulive.member.join.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.seoulive.exception.ControllerException;
import org.zerock.seoulive.exception.ServiceException;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.service.MailSendService;
import org.zerock.seoulive.member.join.service.UserService;

import java.io.File;
import java.util.Objects;


@Log4j2
@NoArgsConstructor

@RequestMapping("/member")
@Controller
public class UserController {
    @Setter(onMethod_ = @Autowired)
    private UserService service;
    @Setter(onMethod_ = @Autowired)
    private MailSendService mailService;


    @GetMapping("/join/main")
    void joinMain() {   // 단순 등록화면 요청
        log.trace("joinMain() invoked.");

    } // joinMain

    @GetMapping("/join/register")
    void register() {   // 단순 등록화면 요청
        log.trace("register() invoked.");

    } // register

    @PostMapping(
            value = "/join/register",
            params = {"email", "password", "birthDate", "gender", "nickname", "introduction"}
    )
    String register(UserDTO dto,  @RequestParam("profileImg") MultipartFile profileImg) throws ControllerException {
        log.trace("register({}, {}) invoked.", dto);

        try {
            Objects.requireNonNull(dto);

//            File savePath = new File("/Users/uneong/temp/upload/" + profileImg.getOriginalFilename());
            File savePath = new File("file:///opt/uploadfiles/" + profileImg.getOriginalFilename());
            profileImg.transferTo(savePath);

            dto.setProfileImgName("static/img/profile/" + profileImg.getOriginalFilename());

            this.service.register(dto);


            return "redirect:/member/join/register";
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // register

    //이메일 인증
    @GetMapping("/join/register/mailCheck")
    @ResponseBody
    public String mailCheck(String email) {
        log.trace("mailCheck({}) invoked.", email);

        return mailService.joinEmail(email);
    } // mailCheck

    // email 중복 체크 컨트롤러
    @PostMapping(value="/emailCheck")
    @ResponseBody
    public int emailCheck(@RequestParam("email") String email) throws ServiceException {
        log.trace("emailCheck({}) invoked.", email);

        try {

            return service.emailCheck(email);
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    } // emailCheck

    @PostMapping(value="/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(@RequestParam("nickname") String nickname) throws ServiceException {
        log.trace("nicknameCheck({}) invoked.", nickname);

        try {

            int result = service.nicknameCheck(nickname);
            log.info("result : {}", result);

//            return service.nicknameCheck(nickname);
            return result;
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    } // nicknameCheck



} // end class
