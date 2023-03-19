package com.zyl.bookstore;

import com.zyl.bookstore.common.utils.SnowflakeId;
import com.zyl.bookstore.entity.User;
import com.zyl.bookstore.mapper.UserMapper;
import com.zyl.bookstore.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author: zyl
 * @date 2023/3/10 18:48
 */
public class MybatisTest {

    @Test
    public void testGetAllUser(){
        UserMapper mapper = MybatisUtil.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }
    @Test
    public void test(){


    }

    @Test
    public void testGetEmpAndDeptStepById(){
        UserMapper mapper  = MybatisUtil.getMapper(UserMapper.class);
        System.out.println(mapper.getUserById(1));
    }

    @Test
    public void testGetUserByUserName(){
        UserMapper mapper  = MybatisUtil.getMapper(UserMapper.class);
        User list = mapper.getUserByUserName("test");
        System.out.println("list = " + list);
    }

    @Test
    public void testRegist(){
        UserMapper mapper = MybatisUtil.getMapper(UserMapper.class);
        User uesr = new User("name", "pwd", "zhuyl1006@163.com");
        mapper.registUser(uesr);

    }
//    雪花算法
    @Test
    public void testSnowflakeIdGenerator(){
        SnowflakeId idGenerator = new SnowflakeId(1, 1); // workerId和datacenterId分别为1
        long id = idGenerator.nextId(); // 生成一个ID
        System.out.println("id = " + id);

    }
}
