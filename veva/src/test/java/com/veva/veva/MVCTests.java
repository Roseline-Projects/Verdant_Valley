package com.veva.veva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.veva.veva.User.controller.UserController;
import com.veva.veva.User.service.UserService;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MVCTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean //mock bean
    private UserService userService;

    @Test
    void shouldReturnUsers() throws Exception { //tests whether getAll endpoint returns 200
        this.mockMvc.perform(get("/users/getAll"))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    void shouldPersistUser() throws Exception { //tests user creation
        when(userService.createUser("Testing user", "test@test.com", "testingtesting123", "HUMAN"))
        .thenReturn(true);

        this.mockMvc.perform(get("/users/createAccount"))
                    .andDo(print())
                    .andExpect(status().isCreated());
    }

}
