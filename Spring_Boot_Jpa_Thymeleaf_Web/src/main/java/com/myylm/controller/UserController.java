package com.myylm.controller;

import com.myylm.commons.web.response.PageResp;
import com.myylm.dto.request.UserDto;
import com.myylm.model.UserModel;
import com.myylm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author hmmzhtx
 */
@Controller
public class UserController {

    public  static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/userPage",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView findPage(@Valid UserDto userDto, BindingResult result, ModelMap modelMap){
        PageResp<UserModel>  page = null;
        if (result.hasErrors()) {
            page =  new PageResp(0L, Lists.newArrayList());
        }else{
            page = userService.findPage(userDto);
        }
        modelMap.put("data",page);
       return new ModelAndView("user",modelMap);
    }


    @RequestMapping(value = "/testView",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView testView(ModelMap modelMap){
        logger.info("testView");
        modelMap.put("data","1111");
        return new ModelAndView("Test",modelMap);
    }




    @RequestMapping(value = "/test",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String test( ){
        System.out.println(1111);
        return "111";
    }





}
