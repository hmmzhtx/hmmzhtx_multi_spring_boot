package com.myylm.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {


    @Autowired
    private  UserController userController;

    private MockMvc mvc;

    //初始化执行
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void testPage() throws Exception {
        String content = "{\"name\":\"ming\",\"page\":\"2\",\"start\":\"1\",\"limit\":\"20\"}";
        ResultActions resultActions = mvc.perform(get("/user/page").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(status().isOk());

        String view_name = resultActions.andReturn().getModelAndView().getViewName();
        System.out.println(view_name);

        Map<String,Object> model_vel = resultActions.andReturn().getModelAndView().getModel();
        System.out.println(model_vel.get("data"));

    }


    @Test
    public void testDto() throws Exception {
        String content = "{\"name\":\"ming\"}";
        String vle = mvc.perform(get("/user/testDto").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("ming"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(vle);
    }


    @Test
    public void testModelView() throws Exception {
        ResultActions resultActions = mvc.perform(get("/user/testView").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        String view_name = resultActions.andReturn().getModelAndView().getViewName();
        System.out.println(view_name);

        Map<String,Object> model_vel = resultActions.andReturn().getModelAndView().getModel();
        System.out.println(model_vel);
    }











}
