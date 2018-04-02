package com.myylm.service.impl;

import com.myylm.commons.web.response.PageResp;
import com.myylm.dto.request.UserDto;
import com.myylm.model.UserModel;
import com.myylm.persistence.UserDao;
import com.myylm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hmmzhtx
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserModel saveUserModel(UserModel userModel) {
        return userDao.save(userModel);
    }

    @Override
    public void delByName(String name) {
        userDao.deleteUserModelByName(name);
    }

    @Override
    public UserModel updateUserModel(UserModel userModel) {
        return userDao.save(userModel);
    }

    @Override
    public UserModel findUserModelByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public PageResp<UserModel> findPage(UserDto userDto) {
        Sort sort = new Sort(Sort.Direction.DESC,"ct");
        PageRequest pageRequest = new PageRequest(userDto.getPage() - 1, userDto.getLimit(),sort);
        Page<UserModel> page = userDao.findAll(new Specification<UserModel>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<UserModel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                List<Expression<Boolean>> expressions = predicate.getExpressions();
                if (StringUtils.isNotBlank(userDto.getName())) {
                    expressions.add(cb.equal(root.<String>get("name"), userDto.getName()));
                }

                if (StringUtils.isNotBlank(userDto.getSex())) {
                    expressions.add(cb.like(root.<String>get("name"), "%"+userDto.getName()+"%"));
                }
                return predicate;
            }
        }, pageRequest);
        return new PageResp(page.getTotalElements(),page.getContent());
    }

}
