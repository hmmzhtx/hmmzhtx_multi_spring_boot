package com.myylm.zhirong.dao;

import com.myylm.zhirong.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

/**
 * 说明：
 * JpaRepository 继承于 PagingAndSortingRepository 接口, 拥有PagingAndSortingRepository 的所有方法，而JpaSpecificationExecutor 不属于Repository 体系。
 * 由于JpaSpecificationExecutor 并不继承repository 接口，所以它不能单独使用，只能和jpa Repository 一起用。
 * JpaRepositor：简单查询
 * JpaSpecificationExecutor： 比较特殊，不属于Repository体系，实现一组JPA Criteria查询相关的方法
 * */
public interface UserDao extends JpaRepository<UserModel, Integer>, JpaSpecificationExecutor<UserModel> {


    /**
     * 通过名称检索信息
     * @param username
     * @return  UserModel
     */
    UserModel findByUsername(@Param("username") String username);


}
