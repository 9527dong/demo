package com.yihaomen.test;

import java.io.Reader;

import com.yihaomen.mybatis.inter.IUserOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yihaomen.mybatis.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class mybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    @Before
    public void init(){
        try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    @Test
    public void test1(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1);
            assertEquals("shanghai,pudong", user.getUserAddress());
            assertEquals("summer", user.getUserName());
        } finally {
            session.close();
        }
    }

    @Test
    public void test2(){
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
}