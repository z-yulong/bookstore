package com.zyl.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyl.bookstore.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: zyl
 * @date 2023/3/15 15:49
 */

public interface UserMapper extends BaseMapper<User> {
    User getUserById(@Param("id") Long id);

    List<User> getAllUser();
    int registUser(User user);
    User getUserByUserName(@Param("username") String username);
}
