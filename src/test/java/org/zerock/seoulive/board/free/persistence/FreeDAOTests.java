//package org.zerock.seoulive.board.free.persistence;
//
//import lombok.Setter;
//import lombok.extern.log4j.Log4j;
//import lombok.extern.log4j.Log4j2;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.zerock.seoulive.board.free.domain.Criteria;
//import org.zerock.seoulive.board.free.domain.FreeDTO;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//// Java Config
//// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class} )
//@Log4j2
//public class FreeDAOTests {
//
//    @Setter(onMethod_ = @Autowired)
//    private FreeDAO freeDAO;
//
//   @Test
//    public void testSearch() {
//       Criteria cri = new Criteria();
//       cri.setKeyword("새로");
//       cri.setType("TC");
//
////       List<FreeDTO> list = freeDAO.getList(cri);
////       list.forEach(board -> log.info(board));
//   }
//
//}
