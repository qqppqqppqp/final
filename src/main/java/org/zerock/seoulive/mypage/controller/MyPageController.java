package org.zerock.seoulive.mypage.controller;






import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.persistence.CourseDAO;
import org.zerock.seoulive.board.course.service.CourseService;

import org.zerock.seoulive.board.review.domain.ReviewBoardVO;
import org.zerock.seoulive.board.review.mapper.ReviewBoardMapper;
import org.zerock.seoulive.board.review.service.ReviewBoardService;
import org.zerock.seoulive.board.travel.domain.TravelBoardVO;
import org.zerock.seoulive.board.travel.mapper.TravelBoardMapper;
import org.zerock.seoulive.board.travel.service.TravelBoardService;
import org.zerock.seoulive.mypage.domain.Criteria;
import org.zerock.seoulive.mypage.domain.PageDTO;
import org.zerock.seoulive.mypage.domain.tbl_likeVO;
import org.zerock.seoulive.mypage.exception.ControllerException;
import org.zerock.seoulive.mypage.mapper.MyPageBoardMapper;
import org.zerock.seoulive.mypage.service.MyPageBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/mypage")
@Controller
public class MyPageController {
	
	@Setter(onMethod_=@Autowired)
	private MyPageBoardMapper mapper;
//	
	@Setter(onMethod_=@Autowired)
	private MyPageBoardService service;

	//-------------------------------------------//
	// 여행
	@Setter(onMethod_=@Autowired)
	private TravelBoardMapper TravelMapper;
	
	@Setter(onMethod_=@Autowired)
	private TravelBoardService TravelService;
	
	// 코스 
	@Setter(onMethod_=@Autowired)
	private CourseDAO CourseMapper;
	
	@Setter(onMethod_=@Autowired)
	private CourseService CourseService;
	
	// 리뷰  
	@Setter(onMethod_=@Autowired)
	private ReviewBoardMapper ReviewMapper;
		
	@Setter(onMethod_=@Autowired)
	private ReviewBoardService ReviewService;
	
//	// 자유 
//	@Setter(onMethod_=@Autowired)
//	private FreeDAO FreeMapper;
//		
//	@Setter(onMethod_=@Autowired)
//	private FreeService FreeService;
	//-------------------------------------------//	
	
	@GetMapping("/mypage")
	public String myPage(String email,Model model,Criteria cri)throws ControllerException  {
		
		log.debug("\t myPage({},{}) invoked.",email);
		
		try {
//			Criteria cri = new Criteria();
//			List<tbl_reviewVO> list = this.mapper.selectLikeReviewList(email, cri);
			List<ReviewBoardVO> result = this.service.getMyReviewList(email, cri);
			model.addAttribute("__RESULT__",result);
			
			PageDTO pageDTO = new PageDTO(cri,this.service.getMyPageReviewTotal(email));
			model.addAttribute("pageMaker",pageDTO);
			
			
			System.out.println("checkPointer1");
			log.info("\t result : {}", result);
			
			System.out.println("checkPointer2");
			
			List<tbl_likeVO> tblLike = this.service.getMyLikeList(email, cri);

			List<TravelBoardVO> tbl_travelList = new ArrayList<>();
			List<CourseVO> tbl_courseList = new ArrayList<>();
			List<ReviewBoardVO> tbl_reviewList = new ArrayList<>();
//			List<FreeDTO> tbl_freeList = new ArrayList<>();
			System.out.println("checkPointer3");
			for(int i = 0 ; i < tblLike.size();i++) {
//				System.out.println(tbl_travelList.get(i));
//				System.out.println(tbl_travelList.get(i).getSeq());
//				System.out.println(tbl_travelList.get(i).getTitle());
//				System.out.println(tbl_travelList.get(i).getBoardSeq());
//				System.out.println(tbl_travelList.get(i).getBoard());
				
				switch(tblLike.get(i).getBoard()) {
					case "tbl_travel" : 
							tbl_travelList.add(this.TravelService.get(tblLike.get(i).getBoardSeq()));
							System.out.println("식별용");
							System.out.println(tbl_travelList.get(0));
							System.out.println("식별용");
							break; 
					case "tbl_course" : 
//							tbl_courseList.add(this.CourseService.get(tblLike.get(i).getBoardSeq()));
					
							break;
					case "tbl_review" : 
							tbl_reviewList.add(this.ReviewService.get(tblLike.get(i).getBoardSeq())); 
							
							break;
					case "tbl_free"   : 
//							tbl_freeList.add(this.FreeService.view(tblLike.get(i).getBoardSeq())); 
							break;
					default : System.out.println(this.getClass().getName()+"null") ; break;
				}	// end switch
			}	// end for
			System.out.println("checkPointer4");
			
//			model.addAttribute("__LIKELIST__",tblLike);
			model.addAttribute("__reviewList__",tbl_reviewList);
			model.addAttribute("__courseList__",tbl_courseList);
			model.addAttribute("__travelList__",tbl_travelList);
//			model.addAttribute("__freeList__",tbl_freeList);
			
			System.out.println("checkPointer3");
			log.info("\t tblLike : {}", tblLike);
//			tblLike.forEach(log::info);
			System.out.println("checkPointer4");
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}	// end try-catch
		return "mypage/mypage";
	}	// end myPage
	
	@GetMapping(path={"/get"},params="seq")
	public void get(@RequestParam("seq") Integer seq, Model model)
		throws ControllerException{
		
		log.trace("\t get({},{}) invoked.",seq,model);
		
		try {
			ReviewBoardVO vo = this.service.getMyReview(seq);
			model.addAttribute("__GETVO__",vo);
			
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		
	}	// end get
	
	
	
	
	
	
}	// end class

