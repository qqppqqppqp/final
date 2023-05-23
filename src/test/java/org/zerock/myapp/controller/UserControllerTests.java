package org.zerock.myapp.controller;


// Junit v5

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/**/root-*.xml",
        "file:src/main/webapp/WEB-INF/**/servlet-*.xml"
})

// Spring Beans Container를 생성해줌
@WebAppConfiguration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTests {

    @Setter(onMethod_ = @Autowired)
    private WebApplicationContext ctx; // MockMvc 객체 생성 시 필요하므로 주입

    private MockMvc mockMvc;

    @BeforeAll
    void beforeAll() {      // 1회성 전처리
        log.trace("beforeAll() invoked.");

        assertNotNull(this.ctx);
        log.info("\t+ 1. ctx : {}", ctx);

        MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
        this.mockMvc = mockMvcBuilder.build();
    } // beforeAll


    @Test
    @Order(1)
    @DisplayName("testRegister")
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testRegister() throws Exception {
        log.trace("testRegister() invoked.");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/member/join/register");
        requestBuilder.param("email", "abcdef@email.com");
        requestBuilder.param("password", "pwdabc");
        requestBuilder.param("nickname", "user111");
        requestBuilder.param("birth_date", "20001221");
        requestBuilder.param("gender", "여");
        requestBuilder.param("introduction", "Hi");

        ModelAndView modelAndView =
                this.mockMvc.
                        perform(requestBuilder).
                        andReturn().
                        getModelAndView();

        String viewName = modelAndView.getViewName();
        log.info("\t+ 1. viewName : {}", viewName);

        ModelMap modelMap = modelAndView.getModelMap();

        assertNotNull(modelMap);
        modelMap.forEach( (k, v) -> log.info("\t+ 2. k : {}, v : {}", k, v) ); // .forEach

    } // testRegister


} // end class