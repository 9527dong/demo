package com.yihaomen.mybatis.inter;

import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;

import java.util.List;

/**
 * Created by Dong on 2017/5/14.
 */
public interface IUserOperation {

    public List<User> selectUsers(String userName);

    public User selectUserByID(int i);

    public void updateUser(User user);

    public void deleteUser(int id);

    public void addUser(User user);

    public List<Article> getUserArticles(int id);
}