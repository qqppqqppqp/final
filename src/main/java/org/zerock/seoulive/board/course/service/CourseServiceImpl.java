package org.zerock.seoulive.board.course.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.*;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.persistence.CourseDAO;
import org.zerock.seoulive.board.travel.domain.TravelDTO;

import java.util.List;
import java.util.Objects;

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
	
	// 6. 게시물 작성
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
	public Integer getCourseSeq() throws ServiceException{
		log.trace("getCourseSeq() invoked.");
		
		return this.dao.getCourseSeq().getSeq();
	}
	@Override
	public void registerTravel(CourseWriteVO vo) throws ServiceException {
		log.trace("register() invoked.");
		
		try {
			this.dao.insertCourseTravel(vo);

		} catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
	} // register
	
	// 7. Write에서 여행지 검색
	@Override
	public List<TravelDTO> getTravelData(String keyword) throws ServiceException{
        return this.dao.getTravelData(keyword);
    } // getTravelData
	
	
	// 8. 찜 기능
	public void courseLike(CourseLikeDTO dto) throws ServiceException {
		
		try {
			this.dao.courseLike(dto);

		} catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
		
	}
	
	
	// 9. 특정 게시물 상세조회 (READ)
	@Override
    public CourseVO get(Integer seq) throws ServiceException {
        log.trace("get() invoked");
        try {
        	return this.dao.read(seq);
        } catch(Exception e){
			throw new ServiceException(e);
		} // try-catch	
    } // get
	@Override
	public void total(Integer seq) throws ServiceException {
		log.trace("get() invoked");
        try {
        	this.dao.total(seq);
        } catch(Exception e){
			throw new ServiceException(e);
		} // try-catch
	} // total
	
	
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
