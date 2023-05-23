//package org.zerock.myapp.mapper;
//
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.extern.log4j.Log4j2;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.zerock.seoulive.member.join.domain.UserDTO;
//import org.zerock.seoulive.member.join.domain.UserVO;
//import org.zerock.seoulive.member.join.exception.ServiceException;
//import org.zerock.seoulive.member.join.mapper.UserMapper;
//import org.zerock.seoulive.member.join.service.UserService;
//
//import java.sql.Timestamp;
//
//import static junit.framework.TestCase.assertNotNull;
//
//
//@Log4j2
//@NoArgsConstructor
//
//// JUnit4
//// Spring Framework 구동
//@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-*.xml"})
//public class UserMapperTests {
//
//    @Setter(onMethod_ = {@Autowired})
//    private UserMapper mapper;
//
//    @Setter(onMethod_ = {@Autowired})
//    private UserService service;
//
//
//    @Before
//    public void setup() {
//        log.trace("setup() invoked.");
//
//        assertNotNull(this.mapper);
//        log.info("\t+ this.mapper : {}", this.mapper);
//    } // setup
//
//
//    @Test(timeout = 1000 * 2)
//    public void testSelectUser() throws ServiceException {       // 단위 테스트
//        log.trace("testSelectUser() invoked.");
//
//        UserDTO dto = new UserDTO();
//        dto.setEmail("destiny8693@gmail.com");
//        dto.setPassword("1234");
//        log.info("\t+ dto : {}", dto);
//
//        UserVO vo = this.service.authenticate(dto);
//        log.info("\t+ vo : {}", vo);
//    } // testSelectUser
//
//    @Test(timeout = 1000 * 2)
//    public void testUpdateUserWithRememberMe() throws Exception {       // 단위 테스트
//        log.trace("testUpdateUserWithRememberMe() invoked.");
//
//        String email = "destiny8693@gmail.com";
//        String rememberMeCookie = "1234567890ABCDEFG";
//
//        long oneWeek = 1000 * 60 * 60 * 24 * 7; // in milliseconds
//        long now = System.currentTimeMillis();  // in milliseconds
//        Timestamp rememberMeCookieMaxAge = new Timestamp(now + oneWeek);
//
//        int affectedLines = this.mapper.updateUserWithRememberMe(email, rememberMeCookie, rememberMeCookieMaxAge);
//        log.info("\t+ affectedLines : {}", affectedLines);
//    } // testUpdateUserWithRememberMe
//
//
//} // end class
