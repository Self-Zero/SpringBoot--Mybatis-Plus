package com.example.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis.domain.UserInfoDomain;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户业务实现
 * @Author Zero
 * @CreateTime 2020/10/09
 */
@Service
@Transactional
public class UserInfoImpl extends ServiceImpl<UserMapper,UserInfoDomain> implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserInfoDomain> getA() {
        List<UserInfoDomain> a = userMapper.getA();
        return a;
    }
}
