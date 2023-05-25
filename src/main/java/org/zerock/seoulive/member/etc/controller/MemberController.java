package org.zerock.seoulive.member.etc.controller;



import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.seoulive.member.etc.domain.tbl_memberVO;
import org.zerock.seoulive.member.etc.exception.ControllerException;
import org.zerock.seoulive.member.etc.mapper.MemberBoardMapper;
import org.zerock.seoulive.member.etc.service.MailSendService;
import org.zerock.seoulive.member.etc.service.MemberBoardSerivce;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Setter(onMethod_=@Autowired)
	private MemberBoardMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private MemberBoardSerivce serivce;
	
	@Setter(onMethod_=@Autowired)
	private MailSendService mailSerivce;
	
	@GetMapping(path="find_id")//,params= {"email"}
	public String find_id(String email, Model model) throws ControllerException{
		//@RequestParam("email") 
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : "+email);
		
		log.trace("\t find_id({}) invoked.",email);
		try {
			tbl_memberVO vo = this.serivce.get(email);
			model.addAttribute("__BOARD__",vo);
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		return "member/find_id";
	}	// end find_id
	
	@PostMapping(path="find_password")	//,params="email"
//	@RequestParam("email") String email,
	public String find_password(Model model)throws ControllerException {
		log.trace("\t find_password({},{}) invoked.",model); //email,
		System.out.println("CheckPointer1");
		try {
			System.out.println("CheckPointer2");
//			model.addAttribute("__EMAIL__",email);
			System.out.println("CheckPointer3");
//			return "member/find_password?email="+email;
			return "member/find_password";
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}

	}	// end find_id
	
	@GetMapping(path="find_email_complete") // ,params="email"
	public String find_id_complete(String email,Model model) throws ControllerException{
		//@RequestParam("email") 
		log.trace("find_id_complete({},{}) invoked.",email,model);
		
		try {
			
			System.out.println("이메일 인증 요청이 들어옴!");
			System.out.println("이메일 인증 이메일 : "+email);
			tbl_memberVO vo = this.serivce.get(email);
			
			model.addAttribute("__BOARD__",vo);
			
			
			return "member/find_email_complete";
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		
	}	// end find_id
	
	// 이메일 인증
	@GetMapping("/controller/find_password")
	@ResponseBody
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청이 들어옴");
		System.out.println("이메일 인증 이메일 : "+email);
		return this.mailSerivce.joinEmail(email);
	}	// end mailCheck
	
	// 회원가입 페이지 이동
	@GetMapping("/userJoin")
	public void userJoin() {}
	
	@PostMapping("/change_password") 
	public void change_password(@RequestParam("email")  String email, @RequestParam("password") String password) throws ControllerException {
		
		try {
			this.serivce.modifyPassword(email, password);
			
//			return "member/change_password";
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end change_password
	
	@GetMapping("/change_password") 
	public String change_password() throws ControllerException {
//		log.info("change_password ({},{},{}) invoked.",email,rttrs,model);
		try {
//			Objects.requireNonNull(vo);
//			if(this.serivce.modifyPassword(vo.getEmail(),vo.getPassword())) {
//				rttrs.addAttribute("result", "true");
			
//			}
			
			return "/member/change_password";
//			return "redirect:member/mypage";
		}catch(Exception e) {
			throw new ControllerException(e);
		}
	}	// end change_password
	
//	@GetMapping("/mypage")
//	public String myPage()throws ControllerException  {
//		
//		log.debug("\t myPage() invoked.");
//		
//		try {
//			return "mypage/mypage";
//		}catch(Exception e) {
//			throw new ControllerException(e);
//		}
//	}	// end myPage
}	// end class

