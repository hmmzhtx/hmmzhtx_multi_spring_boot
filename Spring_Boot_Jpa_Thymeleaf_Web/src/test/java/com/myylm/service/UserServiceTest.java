package com.myylm.service;


import com.myylm.commons.web.response.PageResp;
import com.myylm.dto.request.UserDto;
import com.myylm.model.UserModel;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void saveUserModel(){
        UserModel userModel = new UserModel();
        userModel.setName("张三");
        userModel.setSex("男");
        userService.saveUserModel(userModel);
    }


    @Test
    public void delUserModel(){
        userService.delByName("张三");
    }


    @Test
    public void updateUserModel(){
        UserModel userModel =  userService.findUserModelByName("张三");
        userModel.setName("李四");
        userService.updateUserModel(userModel);
    }


    @Test
    public void findUserModelByName(){
        UserModel userModel =  userService.findUserModelByName("李四");
        System.out.println(userModel.toString());
    }


    @Test
    public void Page(){
        UserDto userDto = new UserDto();
        userDto.setPage(1);
        userDto.setLimit(10);
        userDto.setName("李四");

        PageResp<UserModel> userModelList = userService.findPage(userDto);

        System.out.println(userModelList.getTotalCount());

    }


}
