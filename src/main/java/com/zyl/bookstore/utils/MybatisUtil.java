package com.zyl.bookstore.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
/**

 MybatisUtil 是一个工具类，用于获取 SqlSession 和 Mapper 对象，并提供了关闭 SqlSession 的方法。
 它使用了 ThreadLocal 来保证每个线程获取到的 SqlSession 对象都是独立的。
 使用前需要先配置 mybatis-config.xml 文件，并放置在类路径下。
 <pre>
 使用示例：
 //获取默认自动提交事务的 SqlSession 对象
 SqlSession sqlSession = MybatisUtil.getSqlSession();
 //获取自定义提交事务的 SqlSession 对象
 SqlSession sqlSession = MybatisUtil.getSqlSession(false);
 //获取指定 Mapper 接口的实现类对象
 UserMapper userMapper = MybatisUtil.getMapper(UserMapper.class);
 //获取自定义提交事务的指定 Mapper 接口的实现类对象
 UserMapper userMapper = MybatisUtil.getMapper(UserMapper.class, false);
 //关闭当前线程的 SqlSession 对象
 MybatisUtil.closeSqlSession();
 @author  朱宇龙
 @date 2023/3/10 19:20
 @since   1.0
 */
public class MybatisUtil {
    //存放每个线程的SqlSession对象
    private static final ThreadLocal<SqlSession> SQL_SESSION_THREAD_LOCAL = new ThreadLocal<>();
    // SqlSessionFactory 对象，用于创建 SqlSession 对象
    private static final SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取自定义提交事务的 SqlSession 对象。
     *
     * @param autoCommit 是否自动提交事务
     * @return SqlSession 对象
     */
    public static SqlSession getSqlSession(boolean autoCommit) {
        SqlSession sqlSession = SQL_SESSION_THREAD_LOCAL.get();
        if (sqlSession == null) {
            sqlSession = SQL_SESSION_FACTORY.openSession(autoCommit);
            SQL_SESSION_THREAD_LOCAL.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 获取默认自动提交事务的 SqlSession 对象。
     *
     * @return SqlSession 对象
     */
    public static SqlSession getSqlSession() {
        return getSqlSession(true);
    }

    /**
     * 获取自定义提交事务的指定 Mapper 接口的实现类对象。
     *
     * @param clazz Mapper 接口的 Class 对象
     * @param autoCommit 是否自动提交事务
     * @return Mapper 接口的实现类对象
     */
    public static <T> T getMapper(Class<T> clazz, boolean autoCommit) {
        try{
            SqlSession sqlSession = getSqlSession(autoCommit);
            return sqlSession.getMapper(clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取指定 Mapper 接口的实现类对象。
     *
     * @param clazz Mapper 接口的 Class 对象
     * @return Mapper 接口的实现类对象
     */
    public static <T> T getMapper(Class<T> clazz) {
        return getMapper(clazz, true);
    }
    /**
     * 关闭当前线程的 SqlSession 对象。
     */
    public static void closeSqlSession() {
        SqlSession sqlSession = SQL_SESSION_THREAD_LOCAL.get();
        if (sqlSession != null) {
            try {
                sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                SQL_SESSION_THREAD_LOCAL.remove();
            }
        }
    }

    /**
     * 提交事务
     */
    public static void commitTransaction() {
        SqlSession sqlSession = SQL_SESSION_THREAD_LOCAL.get();
        if (sqlSession != null) {
            try {
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction() {
        SqlSession sqlSession = SQL_SESSION_THREAD_LOCAL.get();
        if (sqlSession != null) {
            try {
                sqlSession.rollback();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}


