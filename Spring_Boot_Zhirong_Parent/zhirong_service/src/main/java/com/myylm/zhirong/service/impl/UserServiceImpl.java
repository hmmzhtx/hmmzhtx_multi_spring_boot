package com.myylm.zhirong.service.impl;

import com.myylm.zhirong.dao.UserDao;
import com.myylm.zhirong.model.UserModel;
import com.myylm.zhirong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author hmmzhtx
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserModel findUserModelByName(String name) {
        return userDao.findByUsername(name);
    }


}
