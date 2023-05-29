package org.zerock.seoulive.board.mypage.serviceTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.review.domain.ReviewBoardVO;
import org.zerock.seoulive.board.travel.domain.TravelBoardVO;
import org.zerock.seoulive.mypage.domain.Criteria;
import org.zerock.seoulive.mypage.domain.tbl_likeVO;
import org.zerock.seoulive.mypage.exception.ServiceException;
import org.zerock.seoulive.mypage.mapper.MyPageBoardMapper;
import org.zerock.seoulive.mypage.service.MyPageBoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)

@WebAppConfiguration

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/**/root-*.xml",
		"file:src/main/webapp/**/servlet-*.xml"
})

public class MyPageBoardSerivceTests {
	
	@Setter(onMethod_= {@Autowired})
	private MyPageBoardMapper mapper;
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	@Setter(onMethod_= {@Autowired})
	private MyPageBoardService service;
	
	private MockMvc mockMvc;
	
	@BeforeAll
	public void beforeAll() {
		
		log.trace("\t beforeAll() invoked.");
		
		assertNotNull(this.ctx);
		
		log.info("\t t1.ctx : {}",this.ctx);
		
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		this.mockMvc = mockMvcBuilder.build();
		
	}	// end beforeAll
	
	@Test
	@Order(10)
	@DisplayName("testGetLikeReviewList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetLikeReviewList() {
		log.trace("\t testGetLikeReviewList() invoked.");
		
		Criteria cri = new Criteria();
		String email = "id@gmail.com";
		List<ReviewBoardVO> result1 = this.mapper.selectLikeReviewList(email,cri);
		
		result1.forEach(log::info);
		
		log.trace("\t end testGetListReviewList() complete");
	}	// end testGetLikeReviewList
	
	@Test
	@Order(11)
	@DisplayName("testGetSelectReview")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetSelectReview() {
		log.trace("\t testGetSelectReview() invoked.");
		
		
		Integer seq = 101;
		ReviewBoardVO result1 = this.mapper.selectReview(seq);
		
		
		
		log.trace("\t end testGetSelectReview({}) complete",result1);
	}	// end testGetLikeReviewList
	
	@Test
	@Order(12)
	@DisplayName("testGetMyLikeList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyLikeList() {
		log.trace("\t testGetMyLikeList() invoked.");
		
		Criteria cri = new Criteria();
		String email = "id@gmail.com";
		List<tbl_likeVO> result1 = this.mapper.selectLikeList(email,cri);
		
//		result1.forEach(log::info);
		

		
		
		
//		System.out.println(result1.get(0));
//		System.out.println(result1.get(0).getSeq());
//		System.out.println(result1.get(0).getEmail());
//		System.out.println(result1.get(0).getBoardSeq());
//		System.out.println(result1.get(0).getBoard());
		
		
		log.trace("\t end testGetMyLikeList() complete");
	}	// end testGetLikeReviewList
	
//	@Test
//	@Order(13)
//	@DisplayName("testGetMyPageReviewTotal")
//	@Timeout(value=5,unit=TimeUnit.SECONDS)
//	public void testGetMyPageReviewTotal() throws ServiceException {
//		log.trace("\t testGetMyPageReviewTotal() invoked.");
//		
//		
//		String email = "id@gmail.com";
//		
//		Integer result = this.servise.getMyPageReviewTotal(email);
//		
//		
//		
//		log.trace("\t end testGetMyPageReviewTotal({}) complete",result);
//	}	// end testGetMyPageReviewTotal
	
	@Test
	@Order(14)
	@DisplayName("testGetMyCourseList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyCourseList() throws ServiceException{
		log.trace("\t testGetMyCourseList () invoked.");
		
		String email = "id@gmail.com";
		
		try {
			
			List<CourseVO> list = this.service.getMyCourseList(email);
			log.info("\t list : {}",list);
		}catch(Exception e) {
			throw new ServiceException(e);
			
		}
	}	// end testGetMyCourseList
	
	@Test
	@Order(15)
	@DisplayName("testGetMyCourse")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyCourse() throws ServiceException{
		log.trace("\t testGetMyCourse() invoked.");
		
		Integer seq = 6;
		try {
			CourseVO result = this.service.getMyCourse(seq);
			log.info("\t result : {}",result);
		}catch(Exception e) {
			throw new ServiceException(e);
		}
	}	// testGetMyCourse
	
	@Test
	@Order(16)
	@DisplayName("tesgGetMyTravelList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyTravelList() throws ServiceException{
		log.trace("\t tesgGetMyTravelList() invoked.");
		
		try {
			String email = "id@gmail.com";
			List<TravelBoardVO> list = this.service.getMyTravelList(email);
			log.info("\t list : {}",list);
		}catch(Exception e) {
			throw new ServiceException(e);
		}
		
	}
	
	@Test
	@Order(17)
	@DisplayName("testGetMyTravelBoard")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyTravelBoard() throws ServiceException {
		log.trace("\t testGetMyTravelBoard() invoked.");
		
		try {
			Integer seq = 15;
			TravelBoardVO result = this.service.getMyTravelBoard(seq);
			log.info("\t result : {}",result);
			
		}catch(Exception e) {
			throw new ServiceException(e);
		}
	}
	
	@AfterAll
	public void afterAll() {
		log.trace("\t afterAll() invoked.");
	}
	
	
}	// end class
