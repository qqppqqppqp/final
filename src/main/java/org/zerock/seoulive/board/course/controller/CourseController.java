package org.zerock.seoulive.board.course.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.seoulive.board.course.domain.*;
import org.zerock.seoulive.board.course.service.CourseService;
import org.zerock.seoulive.board.travel.domain.TravelBoardDTO;
import org.zerock.seoulive.exception.ControllerException;

import java.util.List;


@Log4j2
@NoArgsConstructor

@RequestMapping("/board/course")
@Controller
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	
	// 1. 게시판 목록 조회
//	@GetMapping("/list")
//	void list(CoursePageTO page, Model model) throws ControllerException {
//		log.trace("list({}, {}) invoked.", page, model);
//		
//		try {
//			List<CourseDTO> list = this.service.getList(page);
//			
//			for (int i = 0; i<list.size(); i++) {
//				list.get(i).setListVO(this.service.getTravelList(list.get(i)));
//			} // for
//			model.addAttribute("__LIST__", list);
//			
//			CoursePageDTO pageDTO = new CoursePageDTO(page, this.service.getTotal());
//			model.addAttribute("pageMaker", pageDTO);
//		} catch(Exception e) {
//			throw new ControllerException(e);
//		} // try-catch
//	} // list
	
	// 2. 검색 후 게시판 목록 조회
	@GetMapping("/list")
	void search(CoursePageTO page, Model model) throws ControllerException {
		log.trace("list({}, {}) invoked.", page, model);
		
		try {
			List<CourseDTO> list = this.service.searchCourse(page);
			System.out.println(list.size());
			// Request Scope 공유속성 생성
			
			int size = list.size();
			System.out.println(size);
			
			for (int i = 0; i<size; i++) {
				list.get(i).setListVO(this.service.getTravelList(list.get(i)));
			} // for
			model.addAttribute("__LIST__", list);
			
			CoursePageDTO pageDTO = new CoursePageDTO(page, this.service.getTotalSearch(page));
			model.addAttribute("pageMaker", pageDTO);

		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // search
	
	
	
	// 2. 새로운 게시물 등록
	@PostMapping(path="/register")
	String register(CourseWriteDTO dto) throws ControllerException {
		log.trace("register({}) invoked.", dto);
		
		try {
			
			this.service.register(dto);
			
			return "redirect:/board/course/list";
		} catch(Exception e) {
			e.getStackTrace();
			throw new ControllerException(e);
		} // try-catch
	} // register
	
	@PostMapping(path="/registerTravel")
	String registerTravel(CourseWriteVO vo) throws ControllerException {
		log.trace("register({}) invoked.", vo);
		
		try {
			
			this.service.registerTravel(vo);
			
			return null;
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // register
	
	
	@GetMapping(path="/register")
	String register() {	// 단순 등록화면 요청
		log.trace("register() invoked.");
		
		
		return "/board/course/write";
	} // register
	
	// 작성시 여행지 검색
	@GetMapping("/travel_search")
	public String searchTravelData(String keyword, String resultId, Model model) throws ControllerException {
		
		try {
			
		    List<TravelBoardDTO> travelData = this.service.getTravelData(keyword);
		    model.addAttribute("travelData", travelData);
		    model.addAttribute("resultId", resultId);
		    return "/board/course/searchTravelData"; 
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	}
	
	@PostMapping("/course_like")
	public void courseLike(CourseLikeDTO dto) throws ControllerException {
		log.trace("register({}) invoked.", dto);
		
		try {
			
			this.service.courseLike(dto);
			
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // register
	
	//상세조회
    @GetMapping(path ={ "/get", "/modify"}, params = {"seq"})
    public void get(Integer seq, Model model) throws ControllerException {
       log.trace("get() invoked");

       try {

               CourseVO vo = this.service.get(seq);
               List<CourseTravelVO> travelList = this.service.getTravelList(seq);
               List<CourseCommVO> commList = this.service.commList(seq);
//               Integer total = commservice.getTotal(seq);
//               log.info("댓글 갯수: {}", total);

               model.addAttribute("__BOARD__", vo);
               model.addAttribute("__COURSETRAVELBOARD__", travelList);
               model.addAttribute("__COMMENT_LIST__", commList);
//               model.addAttribute("__COMMENT_TOTAL__",total);

       } catch (Exception e) {
    	   e.getStackTrace();
           throw new ControllerException(e);
       }
    } // get

    @PostMapping("/comm_write")
    public String commRegister(String content, Integer seq) throws ControllerException {
		log.trace("commRegister({}) invoked.", content);

		try {

			this.service.commRegister(content, seq);

			return "redirect:/board/course/get?seq="+seq;
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
    } // commRegister
	
//  수정하기
//    @PostMapping (path = "/modify", params = {"seq"})
//    public String modify(@RequestParam(value="seq") Integer seq,
//                       courseDTO dto,courseTravelDTO coursedto,
//                       Integer currPage,RedirectAttributes rttrs) throws ControllerException {
//        log.trace("modify({}) invoked", dto);
//
//
//        try {
//            Objects.requireNonNull(dto);
//            assert coursedto != null;
//
//            rttrs.addAttribute("currPage", currPage);
//
//            if (this.service.modify(dto)) {
//                rttrs.addAttribute("result", "success");
//                rttrs.addAttribute("seq", dto.getSeq());
//                }
//            return "redirect:/course/list";
//        } catch (Exception e) {
//            throw new ControllerException(e);
//        }
//    }

//	@GetMapping(path="/modify", params="bno")
//	void modify(Integer bno, Model model) {	// 단순 수정화면 요청
//		log.trace("modify() invoked.");
//
//	} // modify		// get메소드로 이동함


	// 5. 특정 게시물 삭제(DELETE)
//    @PostMapping("/remove")
//    public String remove(@RequestParam("seq")
//                             Integer currPage, Integer seq, RedirectAttributes rttrs) throws ControllerException {
//        log.trace("remove({}) inovked", seq);
//
//        try{
//            if(this.service.remove(seq)) {
//                rttrs.addAttribute("currPage", currPage);
//                rttrs.addAttribute("result", "success");
//                rttrs.addAttribute("seq", seq);
//            }
//            return "redirect:/board/course/list";
//        } catch (Exception e) {
//            throw new ControllerException(e);
//        }
//    }
	
} // end class
