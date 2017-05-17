package com.yihaomen.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yihaomen.mybatis.inter.IUserOperation;
import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;

/**
 * Created by Dong on 2017/5/17.
 */
public class springMybatisTest {

    private static ApplicationContext ctx;

    static
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args)
    {
        IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper");
        //测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
        System.out.println("得到用户id=1的用户信息");
        User user = mapper.selectUserByID(1);
        System.out.println(user.getUserAddress());

        //得到文章列表测试
        System.out.println("得到用户id为1的所有文章列表");
        List<Article> articles = mapper.getUserArticles(1);

        for(Article article:articles){
            System.out.println(article.getContent()+"--"+article.getTitle());
        }

    }


}
