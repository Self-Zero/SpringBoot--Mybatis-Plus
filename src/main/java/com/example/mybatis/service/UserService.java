package com.example.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis.domain.UserInfoDomain;

import java.util.List;

/**
 * @Description 用户业务接口
 * @Author Zero
 * @CreateTime 2020/10/09
 */
public interface UserService extends IService<UserInfoDomain> {

    List<UserInfoDomain> getUserInfo();

}
