package com.lx.dao;

import com.lx.pojo.User;
import org.apache.ibatis.annotations.Param;



public interface UserMapper {

    //根据id查询用户
    User queryUsersById(@Param("id") int id);

    //更新用户数据
    int updateUser(User user);
}
