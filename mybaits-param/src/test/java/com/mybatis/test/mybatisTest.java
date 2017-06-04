package com.mybatis.test;

import com.mybatis.inter.IUserOperation;
import com.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class mybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    @BeforeClass
    public static void init(){
        try{
            //根据 全局配置文件， 利用SqlSessionFactoryBuilder 创建SqlSessionFactory
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    /**
     * 1. 单个参数:测试查询条件中单个参数的情况
     */
    @Test
    public void testOneParam(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(1);
            assertEquals("shanghai,pudong", user.getUserAddress());
            assertEquals("summer", user.getUserName());
        } finally {
            session.close();
        }
    }
    /**
     * 2. 测试查询条件中多个参数的情况
     */
    @Test
    public void testManyParam(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByIdAndUserName(1, "summer");
            assertEquals("shanghai,pudong", user.getUserAddress());
            assertEquals("summer", user.getUserName());
        } finally {
            session.close();
        }
    }

    /**
     * 3. 命名参数:测试查询条件中多个参数且接口参数为@Param("id")和@Param("userName")
     */
    @Test
    public void testManyParamByAnnotation(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByIdAndUserName(1, "summer");
            assertEquals("shanghai,pudong", user.getUserAddress());
            assertEquals("summer", user.getUserName());
        } finally {
            session.close();
        }
    }
    /**
     * 4. map:测试查询条件中多个参数且通过Map集合的方式来传递参数
     */
    @Test
    public void testManyParamByMap(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            Map map = new HashMap();
            map.put("id", 1);
            map.put("userName", "summer");
            User user = userOperation.selectUserByMap(map);
            assertEquals("shanghai,pudong", user.getUserAddress());
            assertEquals("summer", user.getUserName());
        } finally {
            session.close();
        }
    }

    /**
     * 5. Pojo：测试查询条件中多个参数且通过POJO的方式来传递参数
     */
    @Test
    public void testManyParamByPojo(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user=new User();
            user.setId(1);
            user.setUserName("summer");
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            user = userOperation.selectUserByPojo(user);
            assertEquals("shanghai,pudong", user.getUserAddress());
            assertEquals("summer", user.getUserName());
        } finally {
            session.close();
        }
    }
}