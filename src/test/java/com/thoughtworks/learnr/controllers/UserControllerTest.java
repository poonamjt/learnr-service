package com.thoughtworks.learnr.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.learnr.models.User;
import com.thoughtworks.learnr.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;


    @Test
    public void shouldTestGetAllUser() throws Exception {
        User user = new User();
        user.setName("testUser");

        List users = Collections.singletonList( user );
        when( userService.getAllItems() ).thenReturn( users );

        mvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(user.getName())));
    }

    @Test
    public void shouldTestAddUser() throws Exception {
        User user = new User();
        String name = "testUser";
        Long userId = 12l;
        user.setName(name);
         user.setUserId(userId);

        when( userService.addUser(anyLong(), anyString())).thenReturn(user);

        mvc.perform(post("/users/addUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content( new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated());

        verify(userService, times(1)).addUser(userId,name);


    }
}