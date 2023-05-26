package org.zerock.seoulive.board.course.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.CourseCommVO;
import org.zerock.seoulive.board.course.domain.CourseDTO;
import org.zerock.seoulive.board.course.domain.CourseLikeDTO;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseTravelVO;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.course.domain.CourseWriteDTO;
import org.zerock.seoulive.board.course.domain.CourseWriteVO;
import org.zerock.seoulive.exception.ServiceException;
import org.zerock.seoulive.board.course.persistence.CourseDAO;
import org.zerock.seoulive.board.travel.domain.TravelBoardDTO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service("courseService")
public class CourseServiceImpl 
	implements 
		CourseService,
		InitializingBean,
		DisposableBean {

	@Setter(onMethod_= {@Autowired})
	private CourseDAO dao;		// 영속성 계층의 DAO 빈 주입받음
	
	
	
//	// 1. 게시판 목록을 얻어 반환해주는 기능 수행
//	@Override
//	public List<CourseDTO> getList(CoursePageTO page) throws ServiceException {
//		log.trace("getList() invoked.");
//		
//		try {
//			return this.dao.courseList(page);
//		} catch(Exception e){
//			throw new ServiceException(e);
//		} // try-catch
//	} // getList
//
//	// 2. 총 게시물 개수 반환
//	@Override
//	public Integer getTotal() throws ServiceException {
//		log.trace("getTotal() invoked.");
//		
//		return this.dao.getTotalAmount();
//	} // getTotal

	// 3. 코스게시물이 가지고 있는 여행지 목록 반환
	@Override
	public List<CourseTravelVO> getTravelList(CourseDTO dto) throws ServiceException {
		log.trace("getTravelList() invoked.");
		
		return this.dao.selectTravelList(dto);
	}
	@Override
	public List<CourseTravelVO> getTravelList(Integer seq) throws ServiceException {
		log.trace("getTravelList() invoked.");
		
		return this.dao.selectTravelList2(seq);
	}
		
	// 4. 검색 후 리스트 반환
	@Override
    public List<CourseDTO> searchCourse(CoursePageTO page) {
        return dao.searchCourse(page);
    }
	
	// 5. 검색 후 게시물 개수 반환
	@Override
	public Integer getTotalSearch(CoursePageTO page) throws ServiceException {
		log.trace("getTotal() invoked.");
		
		return this.dao.getTotalSearch(page.getSearchType(), page.getKeyword());
	} // getTotal
	
	// 6. 
	@Override
	public void register(CourseWriteDTO dto) throws ServiceException {
		log.trace("register() invoked.");
		
		try {
			this.dao.insertCourse(dto);

		} catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
	} // register
	
	@Override
	public void registerTravel(CourseWriteVO vo) throws ServiceException {
		log.trace("register() invoked.");
		
		try {
			this.dao.insertCourseTravel(vo);

		} catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
	} // register
	
	// 7. 
	@Override
	public List<TravelBoardDTO> getTravelData(String keyword) throws ServiceException{
        return this.dao.getTravelData(keyword);
    } // getTravelData
	
	
	// 8.
	public void courseLike(CourseLikeDTO dto) throws ServiceException {
		
		try {
			this.dao.courseLike(dto);

		} catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
		
	}
	
	
	// 9. 
	@Override
    public CourseVO get(Integer seq) throws ServiceException {
        log.trace("get() invoked");
        try {
        	return this.dao.read(seq);
        } catch(Exception e){
			throw new ServiceException(e);
		} // try-catch	
    } // get
	
	// 10. 댓글 리스트
	@Override
	public List<CourseCommVO> commList(Integer seq) throws ServiceException {
		log.trace("commList() invoked");
		
        try {
        	return this.dao.commList(seq);
        } catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
	} // commList
	
	// 11. 댓글 작성
	@Override
	public void commRegister(String content, Integer seq) throws ServiceException {
	log.trace("commRegister() invoked");
		
        try {
        	this.dao.commRegister(content, seq);
        } catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
	} // commRegister

//	@Override
//	public boolean modify(courseDTO course) throws ServiceException {
//		log.trace("modify() invoked.");
//		
//		try {
//			return mapper.update(course) ==1;
//		} catch(Exception e){
//			throw new ServiceException(e);
//		} // try-catch
//	} // modify	
	

//	
//	@Override
//	public boolean remove(Integer seq) throws ServiceException {
//		log.trace("remove() invoked.");
//		
//		try {
//			return mapper.delete(seq) ==1;
//		} catch(Exception e){
//			throw new ServiceException(e);
//		} // try-catch
//	} // remove
	
	
	
	
//	=======================================================================
	
	@Override
	public void afterPropertiesSet() throws Exception { // 초기화(=전처리)
		log.trace("afterPropertiesSet() invoked.");
		
		Objects.requireNonNull(this.dao);
		log.info("\t this.dao: {}", this.dao);
	} // afterPropertiesSet
	
	@Override
	public void destroy() throws Exception {		// 자원해제(=후처리)
		log.trace("destroy() invoked.");
		
	} // destroy

} // end class
