package org.example.collegesphere.controller;

import org.example.collegesphere.model.Users;
import org.example.collegesphere.service.UserSerivce;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(UserController.class)
class UserControllerTest {
    @MockitoBean
    private UserSerivce serivce;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_getAll() throws Exception{
        List<Users> users=new ArrayList<>(
                List.of(new Users(1,"Tornov","0000","xyz@gmail.com","STUDENT",12))
        );
        Mockito.when(serivce.get()).thenReturn(users);

        mockMvc.perform(get("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Tornov"))
                .andExpect(jsonPath("$[0].email").value("xyz@gmail.com"));
    }

}