package org.zerock.seoulive.mypage;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.seoulive.board.course.domain.CourseVO;
import org.zerock.seoulive.board.review.domain.ReviewBoardVO;
import org.zerock.seoulive.board.travel.domain.TravelBoardVO;
import org.zerock.seoulive.mypage.domain.Criteria;
import org.zerock.seoulive.mypage.domain.UserLikeVO;
import org.zerock.seoulive.mypage.domain.tbl_likeVO;
import org.zerock.seoulive.mypage.mapper.MyPageBoardMapper;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/**/root-*.xml",
		"file:src/main/webapp/**/servlet-*.xml"
})
public class myPageMapper {
	
	@Setter(onMethod_=@Autowired)
	private MyPageBoardMapper mapper;
	
	@BeforeAll
	public void beforeAll() {
		log.trace("\t beforeAll() invoked.");
	}	// end beforeAll
	
	@Test
	@Order(10)
	@DisplayName("testSelectLikeReviewList")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	public void testSelectLikeReviewList() {
		log.trace("testSelectLikeReviewList() invoked.");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(5);
		String email = "id@gmail.com";
		List<ReviewBoardVO> reviewVO = this.mapper.selectLikeReviewList(email,cri);
		
		Objects.requireNonNull(reviewVO);
		System.out.println();
		reviewVO.forEach(log::info);
		
		System.out.printf("\n reviewVO : %s\n",reviewVO);
		
	}	//	testSelectLikeReviewList
	
	@Test
	@Order(11)
	@DisplayName("testSelectLikeList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectLikeList() {
		log.trace("\t testSelectLikeList() invoked.");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(5);
		
		String email = "id@gmail.com";
//		
		List<tbl_likeVO> vo = this.mapper.selectLikeList(email, cri);
		
		
		for(int i = 0 ; i < vo.size();i++) {
//			System.out.println(vo.get(i));
//			System.out.println(vo.get(i).getSeq());
//			System.out.println(vo.get(i).getEmail());
//			System.out.println(vo.get(i).getBoardSeq());
//			System.out.println(vo.get(i).getBoard());
			
			switch(vo.get(i).getBoard()) {
				case "tbl_travel" : System.out.println(this.getClass().getName()+"null") ; break; 
				case "tbl_course" : ; break; 
				case "tbl_review" : ; break;
				case "tbl_free"   : System.out.println(this.getClass().getName()+"null") ; break;
				default : System.out.println(this.getClass().getName()+"null") ; break;
			}	// end switch
		}	// end for
		
		log.info("\t email : {}, vo : {}",email,vo);
		
	}	// end testSelectLikeList
	
	@Test
	@Order(12)
	@DisplayName("testGetMyPageReviewTotal")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyPageReviewTotal() {
		log.trace("\t testGetMyPageReviewTotal() invoked.");
		
//		Criteria cri = new Criteria();
//		cri.setCurrPage(5);
		
		String email = "id@gmail.com";
//		
		Integer result = this.mapper.getMyPageReviewTotal(email);
		
		
		log.info("\t email : {}, result : {}",email,result);
		
	}	// end testGetMyPageReviewTotal
	
	@Test
	@Order(13)
	@DisplayName("testGetMyCourseList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyCourseList() {
		log.trace("\t testGetMyCourseList() invoked.");
		List<CourseVO> result = this.mapper.getMyCourseList("id@gmail.com");
		log.info("\t result : {}",result);
	}
	
	@Test
	@Order(14)
	@DisplayName("testGetMyCourse")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyCourse() {
		log.trace("\t testGetMyCourse() invoked.");
		CourseVO result = this.mapper.getMyCourse(258);
		log.info("\t result : {}",result);
	}
	
	@Test
	@Order(15)
	@DisplayName("testGetMyTravelList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMyTravelList() {
		log.trace("\t testGetMyTravelList() invoked.");
		String email = "id@gmail.com";
		List<TravelBoardVO> list = this.mapper.getMyTravelList(email);
		
		log.info("\t list : {}",list);
	}
	
	@Test
	@Order(16)
	@DisplayName("testGetMytravelBoard")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGetMytravelBoard() {
		log.trace("testGetMytravelBoard() invoked.");
		Integer seq = 4;
		TravelBoardVO vo = this.mapper.getMyTravelBoard(seq);
		log.info("\t vo : {}",vo);
	}
	
	@Test
	@Order(17)
	@DisplayName("testSelectUserLikeList")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectUserLikeList() {
		log.trace("\t testSelectUserLikeList() invoked.");
		String email = "id@gmail.com";
		List<UserLikeVO> list = this.mapper.selectUserLikeList(email);
		log.info("\t list : {} ",list);
	}
	@AfterAll
	public void afterAll() {
		log.trace("\t afterAll() invoked.");
	}
	
}	// end class
