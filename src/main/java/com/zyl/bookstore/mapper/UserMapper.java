package com.zyl.bookstore.mapper;

import com.zyl.bookstore.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: zyl
 * @date 2023/3/15 15:49
 */

public interface UserMapper {
    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();
    int registUser(User user);
    User getUserByUserName(@Param("username") String username);
}
