package com.zyl.bookstore;

import com.zyl.bookstore.mapper.UserMapper;
import com.zyl.bookstore.model.entity.User;
import com.zyl.bookstore.utils.MybatisUtil;
import com.zyl.bookstore.utils.SnowflakeId;
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
        MybatisUtil.closeSqlSession();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testGetEmpAndDeptStepById(){
        UserMapper mapper  = MybatisUtil.getMapper(UserMapper.class);
        System.out.println(mapper.getUserById(186589202731896832L));
    }

    @Test
    public void testGetUserByUserName(){
        UserMapper mapper  = MybatisUtil.getMapper(UserMapper.class);
        User list = mapper.getUserByUserName("test");
        System.out.println("list = " + list);
    }

    @Test
    public void testRegist(){
        try {
            UserMapper mapper = MybatisUtil.getMapper(UserMapper.class,false);
            User uesr = new User(123323L,"na2medRR", "pwd", "zhuyl1006@163.com");
            mapper.registUser(uesr);
            MybatisUtil.commitTransaction();
        }catch (Exception e){
            MybatisUtil.rollbackTransaction();
        }

    }
//    雪花算法
    @Test
    public void testSnowflakeIdGenerator(){
        SnowflakeId idGenerator = new SnowflakeId(1, 1); // workerId和datacenterId分别为1
        long id = idGenerator.nextId(); // 生成一个ID
        System.out.println("id = " + id);

    }
}
