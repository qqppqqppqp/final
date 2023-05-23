//package org.zerock.myapp.mapper;
//
//
//// JUnit4
//
//import lombok.NoArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@Log4j2
//@NoArgsConstructor
//
//// Spring Framework 구동
//@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {
//        "file:src/main/webapp/WEB-INF/**/root-*.xml"
//})
//public class JUnit4Template {
//
//    @Before
//    public void setup() {
//        log.trace("setup() invoked.");
//
//    } // setup
//
//    @Test(timeout = 1000 * 2)
//    public void contextLoads() {
//        log.trace("contextLoads() invoked.");
//
//    } // contextLoads
//
//    @Test
//    public void test2() {
//        log.trace("test2() invoked.");
//
//    } // test2
//
//    @After
//    public void tearDown() {
//        log.trace("tearDown() invoked.");
//
//    } //tearDown
//
//
//} // end class
