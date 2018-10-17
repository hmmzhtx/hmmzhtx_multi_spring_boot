package com.myylm.zhirong.service;


import com.myylm.zhirong.model.UserModel;

/**
 * @author hmmzhtx
 */

public interface UserService {

    /**
     * 根据名称查询
     * @param  name
     * @return UserModel
     * */
    UserModel findUserModelByName(String name);




}
