//package org.zerock.myapp.service;
//
//
//// JUnit4
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
//import org.zerock.seoulive.member.join.exception.ServiceException;
//import org.zerock.seoulive.member.join.domain.UserDTO;
//import org.zerock.seoulive.member.join.service.UserService;
//
//import static org.junit.Assert.assertNotNull;
//
//@Log4j2
//@NoArgsConstructor
//
//// Spring Framework 구동
//@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {
//        "file:src/main/webapp/WEB-INF/**/root-*.xml"
//})
//public class UserServiceTests {
//    @Setter(onMethod_ = {@Autowired})
//    private UserService service;
//
//
//    @Before
//    public void setup() {
//        log.trace("setup() invoked.");
//
//        assertNotNull(this.service);
//        log.info("\t+ this.service : {}", this.service);
//    } // setup
//
////    @Test(timeout = 1000)
////    public void testGetList() throws ServiceException {
////        log.trace("testGetList() invoked.");
////
////        List<UserVO> list = this.service.getList();
////        Objects.requireNonNull(list);
////        list.forEach(log::info);
////    } // testGetList
//
//    @Test(timeout = 1000)
//    public void testRegister() throws ServiceException {
//        log.trace("testRegister() invoked.");
//
//        UserDTO dto = new UserDTO();
//        dto.setEmail("abc@email.com");
//        dto.setPassword("abc1234");
//        dto.setNickName("nick");
//        dto.setBirthDate("19990203");
//        dto.setGender("여");
//        dto.setIntroduction("Hello");
//        log.info("\t+ dto : {}", dto);
//
//        Boolean isSuccess = this.service.register(dto);
//        log.info("\t+ isSuccess : {}", isSuccess);
//    } // testRegister
//
////    @Test(timeout = 1000)
////    public void testGet() throws ServiceException {
////        log.trace("testGet() invoked.");
////
////        int bno = 2221;
////        BoardVO vo = this.service.get(bno);
////
////        assert vo != null;
////        log.info("\t+ vo : {}", vo);
////    } // testGet
////
////    @Test(timeout = 1000)
////    public void testModify() throws ServiceException {
////        log.trace("testModify() invoked.");
////
////        int bno = 2221;
////        BoardVO vo = this.service.get(bno);
////
////        BoardDTO dto = vo.toDTO();
////        dto.setTitle("MODIFIED_TITLE");
////
////        assertNotNull(dto);
////        log.info("\t+ dto : {}", dto);
////
////        boolean isSuccess = this.service.modify(dto);
////        log.info("\t+ isSuccess : {}", isSuccess);
////    } // testModify
////
////    @Test(timeout = 1000)
////    public void testRemove() throws ServiceException {
////        log.trace("testRemove() invoked.");
////
////        int bno = 2221;
////        Boolean isDeleted = this.service.remove(bno);
////        log.info("\t+ isDeleted : {}", isDeleted);
////    } // testRemove
//
//} // end class