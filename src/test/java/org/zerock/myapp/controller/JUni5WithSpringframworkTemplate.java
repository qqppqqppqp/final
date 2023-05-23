package org.zerock.myapp.controller;


// Junit v5

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;


@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/**/root-*.xml",
        "file:src/main/webapp/WEB-INF/**/servlet-*.xml"
})

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUni5WithSpringframworkTemplate {

    @BeforeAll
    void beforeAll() {      // 1회성 전처리
        log.trace("beforeAll() invoked.");

    } // beforeAll

    @BeforeEach
    void beforeEach() {     // 단위 테스트 수행시 전처리
        log.trace("beforeEach() invoked.");

    } // beforeEach


//    @Disabled
    @Test
    @Order(1)
    @DisplayName("contextLoads")
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void contextLoads() {       // 단위 테스트
        log.trace("contextLoads() invoked.");

    } // contextLoads


    @AfterAll
    void AfterAll() {           // 1회성 후처리
        log.trace("AfterAll() invoked.");

    } // AfterAll

    @AfterEach
    void AfterEach() {          // 단위 테스트 수행시 후처리
        log.trace("AfterEach() invoked.");

    } // AfterEach



} // end class
