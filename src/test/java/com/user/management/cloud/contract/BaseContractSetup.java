package com.user.management.cloud.contract;

import com.user.management.UserApplication;
import com.user.management.controller.UserController;
import com.user.management.model.User;
import com.user.management.service.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMessageVerifier
public class BaseContractSetup {

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @Before
    public void setup() {
        // restassure configuration setup to skip optional security filters
        RestAssuredMockMvc.config = RestAssuredMockMvc.config()
                .mockMvcConfig(RestAssuredMockMvc.config().getMockMvcConfig()
                        .dontAutomaticallyApplySpringSecurityMockMvcConfigurer());

        // setup rest end-point for the test
        RestAssuredMockMvc.standaloneSetup(userController);
        // mocking business layers.
        Mockito.when(userService.list()).thenReturn(getMockData1());
    }

    public Iterable<User> getMockData1() {
        List<User> userList = new ArrayList<>();
        User user= null;
        user= new User();
        user.setId(1L);
        user.setUsername("Arup D Chanda");
        userList.add(new User());
        user= new User();
        user.setId(3L);
        user.setUsername("Sumit");
        userList.add(new User());
        return userList;
    }
}
