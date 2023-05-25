//package org.zerock.seoulive.controller;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.Date;
//import java.util.Objects;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.Timeout;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.ModelAndView;
//import org.zerock.seoulive.board.course.domain.tbl_courseDTO;
//import org.zerock.seoulive.board.course.domain.tbl_courseVO;
//import org.zerock.seoulive.board.course.mapper.CourseBoardMapper;
//import org.zerock.seoulive.board.course.persistence.CourseDAO;
//
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.extern.log4j.Log4j2;
//
//@Log4j2
//@NoArgsConstructor
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestInstance(Lifecycle.PER_CLASS)
//
//@WebAppConfiguration
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = {
//		"file:src/main/webapp/**/root-*.xml",
//		"file:src/main/webapp/**/servlet-*.xml"
//})
//
//public class CourseControllerTests {
//	
//	@Setter(onMethod_=@Autowired)
//	private CourseDAO mapper;
//	
//	@Setter(onMethod_=@Autowired)
//	private WebApplicationContext ctx;
//	
//	private MockMvc mockMvc;
//	
//	@BeforeAll
//	void beforeAll() {
//		log.trace("\t beforeAll() invoked.");
//		
//		assertNotNull(this.ctx);
//		
//		log.info("\t t1.ctx : {}",this.ctx);
//	
//		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
//		this.mockMvc = mockMvcBuilder.build();
//	}	// end BeforeAll
//	
//	@Test
//	@Order(0)
//	@DisplayName("testGetCurrentDay")
//	@Timeout(value=5,unit=TimeUnit.SECONDS)
//	Date testGetCurrentDay() {
//		
//		return this.mapper.selectDate();
//	}	// end testGetCurrentDay
//	
//	@Test
//	@Order(1)
//	@DisplayName("testPlusDate")
//	@Timeout(value=5,unit=TimeUnit.SECONDS)
//	Date testPlusDate() {
//		return this.mapper.plusDate();
//	}	// testPlusDate
//	
//	@Test
//	@Order(18)
//	@DisplayName("testSelectList")
//	@Timeout(value=5,unit = TimeUnit.SECONDS)
//	void testSelectList() throws Exception {
//		log.trace("\t testSelectList() invoked.");
//		
//		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/course/list"); 
//		
//		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
//		MvcResult mvcResult = resultActions.andReturn();
//		
//		ModelAndView modelAndView = mvcResult.getModelAndView();
//		Objects.requireNonNull(modelAndView);
//		
//		log.info("\t modelAndView : {}, \t type : {}",modelAndView,modelAndView.getClass().getName());
//	}	// end testSelectList
//	
//	@Test
//	@Order(19)
//	@DisplayName("testSelect")
//	@Timeout(value=5,unit=TimeUnit.SECONDS)
//	void testSelect() {
//		log.trace("\t testSelect() invoked.");
//		
//		tbl_courseVO result1 = this.mapper.select(1);
//		
//		log.info("\t result1 : {}",result1);
//		
//		
//	}	// end testSelect
//	
//	@Test
//	@Order(20)
//	@DisplayName("testInsert")
//	@Timeout(value=300, unit=TimeUnit.SECONDS)
//	void testInsert() { // 게시글 정보 등록 
//		
//			log.trace("\t testInsert() invoked.");
//			
//			tbl_courseDTO dto = new tbl_courseDTO();
//			dto.setSeq(288);
//			dto.setWriter("nick");
//			dto.setTitle("경주여행");
//			dto.setReview("즐거운 경주여행을 합니다.");
//			dto.setTotal(124);
//			dto.setWrite_Date(this.testGetCurrentDay());
//			dto.setDuration_Start(this.testGetCurrentDay());
//			dto.setDuration_End(this.testPlusDate());
//			
//			Integer affectedLines = this.mapper.insert(dto);
//			
//			log.info("\t affectedLines : {}", affectedLines == 1);
//		
//	}	// end testInsert
//	
//	@Test
//	@Order(21)
//	@DisplayName("testUpdate")
//	@Timeout(value=5,unit=TimeUnit.SECONDS)
//	public void testUpdate() {
//		log.trace("\t testUpdate() invoked.");
//		
//		tbl_courseDTO dto = new tbl_courseDTO();
//		dto.setSeq(11);
//		dto.setWriter("Ex");
//		dto.setTitle("그냥 넣어본거 다시 수정");
//		dto.setReview("qwefosadfoasdofjlaksdfjlasfjd");
//		Integer affectedLines = this.mapper.update(dto);
//		log.info("\t affectedLines : {}",affectedLines);
//		log.info("\t is Success : {}",affectedLines==1);
//	}	// end testUpdate
//	
//	@Test
//	@Order(22)
//	@DisplayName("testDelete")
//	@Timeout(value=5,unit=TimeUnit.SECONDS)
//	public void testDelete() {
//		
//		log.trace("\t testDelete() invoked.");
//		
//		Integer seq = 12;
//		Integer affectedLines = this.mapper.delete(seq);
//		
//		log.info("\t seq : {}",seq);
//		log.info("\t affectedLines : {}",affectedLines);
//		log.info("\t is Success : {}",affectedLines == 1);
//	}	// testDelete
//	
//	
//	@AfterAll
//	void afterAll() {
//		log.trace("\t afterAll() invoked.");
//	}	// end afterAll
//	
//}	// end class
