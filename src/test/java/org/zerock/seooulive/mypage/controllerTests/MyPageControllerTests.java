package org.zerock.seooulive.mypage.controllerTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Objects;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.seoulive.board.review.domain.ReviewBoardVO;
import org.zerock.seoulive.mypage.mapper.MyPageBoardMapper;

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

public class MyPageControllerTests {
	@Setter(onMethod_= {@Autowired})
	private MyPageBoardMapper mapper;
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@BeforeAll
	public void beforeAll() {
		log.trace("\t beforeAll() invoked.");
		
		assertNotNull(this.ctx);
		
		log.info("\t t1.ctx : {}",this.ctx);
		
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		this.mockMvc = mockMvcBuilder.build();
	}	// beforeAll
	
	@Test
	@Order(10)
	@DisplayName("testMyPage")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testMyPage() throws Exception{
		
		log.trace("\t testMyPage() invoked.");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mypage/mypage?email=id@gmail.com");
		
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		
		ModelAndView modelAndView = mvcResult.getModelAndView();
		Objects.requireNonNull(modelAndView);
		
		log.info("\t modelAndView : {}, type : {}",modelAndView,modelAndView.getClass().getName());
		
	}	// testMyPage
	
	@Test
	@Order(11)
	@DisplayName("testGet")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testGet() throws Exception{
		
		log.trace("\t testGet() invoked.");
		
		Integer seq = 101;
		ReviewBoardVO vo = this.mapper.selectReview(seq);
		log.info("\t seq : {} , vo : {}",seq,vo);
		
	}	// testMyPage
	
	@AfterAll
	public void afterAll() {
		log.trace("\t afterAll() invoked.");
	}
}	// end MyPageControllerTests
