package com.zyl.bookstore.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: zyl
 * @date 2023/3/10 19:20
 */
public class  MybatisUtil<T> {
    private static SqlSession sqlSession = null;
    private static InputStream is = null;
    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder = null;
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    public static SqlSession getSqlSession() {
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

    public static <T> T getMapper(Class<T> clazz) {
        T mapper = sqlSession.getMapper(clazz);
        return mapper;
    }

}
