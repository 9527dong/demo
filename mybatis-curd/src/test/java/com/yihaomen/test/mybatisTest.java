package com.yihaomen.test;

import java.io.Reader;
import java.util.List;

import com.yihaomen.mybatis.inter.IUserOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yihaomen.mybatis.model.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class mybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    //初始化h2数据库，使用@BeforeClass可以使得h2数据库只被初始化一次
    @BeforeClass
    public static void init(){
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
    public void getUserList(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            List<User> users = userOperation.selectUsers("summer");
            for(User user:users){
                System.out.println(user.getId()+":"+user.getUserName()+":"+user.getUserAddress());
            }

        } finally {
            session.close();
        }
    }
    /**
     * 测试增加,增加后，必须提交事务，否则不会写入到数据库.
     */
    @Test
    public void addUser(){
        User user=new User();
        user.setUserAddress("man");
        user.setUserName("bird");
        user.setUserAge(String.valueOf(80));
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("current userid:"+user.getId());
        } finally {
            session.close();
        }
    }

    @Test
    public void updateUser(){
        //先得到用户,然后修改，提交。
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(1);
            user.setUserAddress("baode");
            userOperation.updateUser(user);
            session.commit();

        } finally {
            session.close();
        }
    }

    /**
     * 删除数据，删除一定要 commit.
     */
    @Test
    public void deleteUser(){
        int id = 1;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.deleteUser(id);
            session.commit();
        } finally {
            session.close();
        }
    }

}