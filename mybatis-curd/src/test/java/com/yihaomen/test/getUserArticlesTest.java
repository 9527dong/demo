package com.yihaomen.test;

import com.yihaomen.mybatis.inter.IUserOperation;
import com.yihaomen.mybatis.model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

/**
 * Created by Dong on 2017/5/16.
 */
public class getUserArticlesTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    //初始化h2数据库，使用@BeforeClass可以使得h2数据库只被初始化一次
    @BeforeClass
    public static void init(){
        try{
            reader    = Resources.getResourceAsReader("Configuration-1.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    @Test
    public void getUserArticles(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            List<Article> articles = userOperation.getUserArticles(1);
            for(Article article:articles){
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":作者是:"+article.getUser().getUserName()+":地址:"+
                        article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }
}
