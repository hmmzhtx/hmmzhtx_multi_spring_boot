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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @author hmmzhtx
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    public  static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ModelAndView findPage(@Valid @RequestBody UserDto userDto, BindingResult result, ModelMap modelMap){
        PageResp<UserModel>  page = null;
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                System.out.println(error.getCode()+" msg="+ error.getDefaultMessage());
            }
            page =  new PageResp(0L, Lists.newArrayList());
        }else{
            page = userService.findPage(userDto);
        }
        modelMap.put("data",page);
       return new ModelAndView("user",modelMap);
    }


    @RequestMapping(value = "/testView",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView testView(ModelMap modelMap){
        modelMap.put("data","1111");
        return new ModelAndView("test",modelMap);
    }




    @RequestMapping(value = "/testDto",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public UserDto testDto( @RequestBody UserDto userDto ){
        System.out.println(userDto.getName());
        return userDto;
    }





}
