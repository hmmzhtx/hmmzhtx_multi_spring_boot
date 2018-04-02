package com.myylm.service;

import com.myylm.commons.web.response.PageResp;
import com.myylm.dto.request.UserDto;
import com.myylm.model.UserModel;

/**
 * @author hmmzhtx
 */

public interface UserService {

    /**
     * 保存对象
     * @param  userModel
     * @return UserModel
     * */
    UserModel saveUserModel(UserModel userModel);


    /**
     * 根据名称删除对象
     * @param  name
     * @return
     * */
    void delByName(String name);

    /**
     * 修改对象
     * @param  userModel
     * @return userModel
     * */
    UserModel updateUserModel(UserModel userModel);
    

    /**
     * 根据名称查询
     * @param  name
     * @return UserModel
     * */
    UserModel findUserModelByName(String name);


    /**
     * 分页查询
     * @param  userDto
     * @return Page<UserModel>
     * */
    PageResp<UserModel> findPage(UserDto userDto);



}
