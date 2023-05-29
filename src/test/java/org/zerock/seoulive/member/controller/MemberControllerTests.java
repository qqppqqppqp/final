package org.zerock.seoulive.member.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
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
import org.zerock.seoulive.member.information.domain.tbl_memberDTO;
import org.zerock.seoulive.member.information.domain.tbl_memberVO;
import org.zerock.seoulive.member.information.mapper.MemberBoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

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

public class MemberControllerTests {
	
	@Setter(onMethod_=@Autowired)
	private MemberBoardMapper mapper;
	
//	@Setter(onMethod_=@Autowired)
//	private WebApplicationContext ctx;
//	
//	private MockMvc mockMvc;
	
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
	
	@Test
	@Order(0)
	@DisplayName("testGetDate")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public Date testGetDate() {
		return this.mapper.GetDate();
	}
	
	@Test
	@Order(1)
	@DisplayName("testGetDate")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public Date testGetJoin_date() {
		return this.mapper.getJoin_date();
	}
	
	@Test
	@Order(2)
	@DisplayName("testSelectPassword")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectPassword() {
		
		System.out.println("pinter1");
		log.trace("\t testSelectPassword() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		String result = this.mapper.selectPassword("id@gmail.com");
		System.out.println("pinter4");
		log.info("\t password : {}",this.mapper.selectPassword("id@gmail.com"));
		System.out.println("pinter5");
		System.out.println();
	}	// end testSelectPassword
	
	// 보류 회원정보 전체를 넣어야하는데, 비밀번호 값을 기존 멤버테이블의 회원에게 넣기 때문에
	//  update와 다를 바가 없다.
//	@Test
//	@Order(2)
//	@DisplayName("testInsertPassword")
//	@Timeout(value=5,unit=TimeUnit.SECONDS)
//	public void testInsertPassword() {
//		
//		System.out.println("pinter1");
//		log.trace("\t testInsertPassword() invoked.");
//		System.out.println("pinter2");
//		
//		System.out.println("pinter3");
//		String resut = this.mapper.insertPassword("id@gmail.com","abc1234");
//		System.out.println("pinter4");
//		log.info("\t password : {}",this.mapper.insertPassword("id@gmail.com","abc1234"));
//		System.out.println("pinter5");
//		System.out.println();
//		
//	}	// end testInsertPassword
	
	@Test
	@Order(4)
	@DisplayName("testUpdatePassword")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testUpdatePassword() {
		
		System.out.println("pinter1");
		log.trace("\t testUpdatePassword() invoked.");
		System.out.println("pinter2");
		
		String email = "id@gmail.com";
		tbl_memberVO vo = this.mapper.selectEmail(email);
		System.out.println(vo);
		assertNotNull(vo);
		System.out.println("pinter3");
		tbl_memberDTO dto = vo.toDTO();
		System.out.println(dto);
		dto.setPassword("giseo1234");
//		
//
//		
		System.out.println("pointer4");
//		
		Integer affectedLine = this.mapper.updatePassword(dto);
		log.trace("\t testUpdatePassword({}) complete.",affectedLine ==1);
		System.out.println("pointer5");
//		System.out.println();
		
	}	// end testUpdatePassword
	
	@Test
	@Order(5)
	@DisplayName("testSelectEmail")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectEmail() {
		
		System.out.println("pointer1");
		log.trace("\t testSelectEmail() invoked.");
		System.out.println("pointer2");
		
		System.out.println("pointer3");
		tbl_memberVO result = this.mapper.selectEmail("id@naver.com");
		System.out.println("pointer4");
		log.trace("\t testSelectEmail({}) complete.",result);
		System.out.println("pointer5");
//		log.trace("\t testSelectEmail({}) complete.",this.mapper.selectEmail("testEmail12@naver.com"));
//		log.trace(":\t result.get(0) : {}", result.get(0));
		System.out.println();
		
	}	// end testSelectEmail
	
	@Test
	@Order(6)
	@DisplayName("testCreateUser")
	@Timeout(value=30,unit=TimeUnit.SECONDS)
	public void testCreateUser() {
		
		for( int i =1 ; i < 11 ; i++) {
		
		System.out.println("pinter1");
		log.trace("\t testCreateUser() invoked.");
		System.out.println("pinter2");
		
		
		
		System.out.println("pinter3");
		
		String email = "testEmail"+i+"@naver.com";
		String password = "test1234"+i;
		String nickName = "test"+i;
		Date birth_date = this.testGetDate();
		Date join_date = this.testGetJoin_date();
		String gender = "남";
		String introduction = "테스트용"+i;
		String profile_img ="";
		
		System.out.println("pinter4");
		
		this.mapper.createUser(
				email,
				password,
				nickName,
				birth_date,
				join_date,
				gender,
				introduction,
				profile_img
				);
		System.out.println("pinter5");
		log.trace("\t testCreateUser({}) complete.");
		System.out.println("pinter6");
		}
	}	// end testCreateUser
	
	@Test
	@Order(7)
	@DisplayName("testDeleteEmail")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testDeleteEmail() {
		
		for(int i = 1 ; i < 20 ; i++) {
		
		System.out.println("pinter1");
		log.trace("\t testDeleteEmail() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		this.mapper.deleteEmail("testEmail"+i+"@naver.com");
		System.out.println("pointer4");
		log.trace("\t testDeleteEmail({}) complete.");
		System.out.println("pointer5");
		System.out.println();
		}
		
	}	// end testDeleteEmail
	
	@Test
	@Order(8)
	@DisplayName("testSelectBirthDate")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectBirthDate() {
		
		System.out.println("pinter1");
		log.trace("\t testSelectBirthDate() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		Date result = this.mapper.selectBirthDate("id@gmail.com");
		System.out.println("pointer4");
		log.trace("\t testSelectBirthDate({}) complete.",result);
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testSelectBirthDate
	
	@Test
	@Order(9)
	@DisplayName("testUpdateBirthDate")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testUpdateBirthDate() {
		
		System.out.println("pinter1");
		log.trace("\t testInsertBirthDate() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		this.mapper.updateBirthDate("2023-04-12","id@gmail");
		System.out.println("pointer4");
		log.trace("\t testUpdateBirthDate({}) complete.");
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testInsertBirthDate
	
	@Test
	@Order(10)
	@DisplayName("testSelectJoinDate")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectJoinDate() {
		
		System.out.println("pinter1");
		log.trace("\t testSelectJoinDate() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		Date result = this.mapper.selectJoinDate("testEmail13@naver.com");
		System.out.println("pointer4");
		log.trace("\t testSelectJoinDate({}) complete.",result);
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testSelectJoinDate
	
	@Test
	@Order(11)
	@DisplayName("testUpdateJoinDate")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testUpdateJoinDate() {
		
		System.out.println("pinter1");
		log.trace("\t testUpdateJoinDate() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		this.mapper.updateJoinDate("2023-5-15","id@gmail");
		System.out.println("pointer4");
		log.trace("\t testUpdateJoinDate({}) complete.");
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testUpdateJoinDate
	
	@Test
	@Order(12)
	@DisplayName("testSelectGender")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectGender() {
		
		System.out.println("pinter1");
		log.trace("\t testSelectGender() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		String result = this.mapper.selectGender("testEmail13@naver.com");
		System.out.println("pointer4");
		log.trace("\t testSelectGender({}) complete.",result);
		log.trace("\t result : {}",result);
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testSelectGender
	
	@Test
	@Order(13)
	@DisplayName("testUpdateGender")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testUpdateGender() {
		
		System.out.println("pinter1");
		log.trace("\t testUpdateGender() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		this.mapper.updateGender("testEmail13@naver.com","여");
		System.out.println("pointer4");
		log.trace("\t testUpdateGender({}) complete.");
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testUpdateGender
	
	@Test
	@Order(14)
	@DisplayName("testSelectIntroduction")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectIntroduction() {
		
		System.out.println("pinter1");
		log.trace("\t testSelectIntroduction() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		String result = this.mapper.selectIntroduction("testEmail13@naver.com");
		System.out.println("pointer4");
		log.trace("\t testSelectIntroduction({}) complete.",result);
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testSelectIntroduction
	
	@Test
	@Order(15)
	@DisplayName("testUpdateIntroduction")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testUpdateIntroduction() {
		
		System.out.println("pinter1");
		log.trace("\t testUpdateIntroduction() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		this.mapper.updateIntroduction("testEmail13@naver.com","testUpdateIntroduction을 실행하였습니다.");
		System.out.println("pointer4");
		log.trace("\t testUpdateIntroduction({}) complete.");
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testUpdateIntroduction
	
	@Test
	@Order(14)
	@DisplayName("testSelectProfielImg")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testSelectProfielImg() {
		
		System.out.println("pinter1");
		log.trace("\t testSelectProfielImg() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		String result = this.mapper.selectProfileImg("testEmail13@naver.com");
		System.out.println("pointer4");
		log.trace("\t testSelectProfielImg({}) complete.",result);
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testSelectProfielImg
	
	@Test
	@Order(15)
	@DisplayName("testUpdateIntroduction")
	@Timeout(value=5,unit=TimeUnit.SECONDS)
	public void testUpdateProfielImg() {
		
		System.out.println("pinter1");
		log.trace("\t testUpdateProfielImg() invoked.");
		System.out.println("pinter2");
		
		System.out.println("pinter3");
		this.mapper.updateProfileImg("testEmail13@naver.com","/users/temp/profile/profile.png");
		System.out.println("pointer4");
		log.trace("\t testUpdateProfielImg({}) complete.");
		System.out.println("pointer5");
		System.out.println();
		
	}	// end testUpdateProfielImg
	
	@AfterAll
	void afterAll() {
		log.trace("\t afterAll() invoked.");
	}	// end afterAll
	
}	// end class
