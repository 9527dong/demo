package com.yihaomen.test;

import java.io.Reader;
import java.math.BigDecimal;
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
    @BeforeClass
    public static void init(){
        try{
            // 1.根据 全局配置文件， 利用SqlSessionFactoryBuilder 创建SqlSessionFactory
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
     * 1. mybatis的HelloWorld
     */
    @Test
    public void test(){
        //使用 SqlSessionFactory 获取 sqlSession 对象。一 个 SqlSession 对象代表和数据库的一次会话
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = session.selectOne("helloworld.selectUserByID", 1);
            List users = session.selectList("helloworld.selectUserByID", 1);
            System.out.println(users);
            assertEquals("shanghai,pudong", user.getUserAddress());
            assertEquals("summer", user.getUserName());
        } finally {
            session.close();
        }
    }

    /**
     * 2. 接口式编程
     * IUserOperation 接口没有实现类，但是mybatis会为这个接口自动生成一个代理对象
     */
    @Test
    public void testInterface(){
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

    public static void main(String[] args) {
        String externalSkUId = "23558462_2019-03-17_1";
        String proDuctNo = externalSkUId.split("_")[0];
        String date = externalSkUId.split("_")[1];
        String period = externalSkUId.split("_")[2];

        BigDecimal bigDecimal = new BigDecimal(22.22);
        System.out.println(Double.valueOf(bigDecimal.doubleValue()*100).intValue());
    }
}