package com.example.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis.domain.UserInfoDomain;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 用户信息DAO
 * @Author Zero
 * @CreateTime 2020/10/09
 */
@Repository
public interface UserMapper extends BaseMapper<UserInfoDomain> {

    @Select("select * from user_info")
    List<UserInfoDomain> getUserInfo();

}
