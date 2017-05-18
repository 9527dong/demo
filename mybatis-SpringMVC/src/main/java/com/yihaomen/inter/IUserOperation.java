package com.yihaomen.inter;

import java.util.List;

import com.yihaomen.model.Article;
import com.yihaomen.model.User;

public interface IUserOperation {
    
	public User selectUserByID(int id);
	public List<User> selectUsers(String userName);	
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	
	public List<Article> getUserArticles(int id);
	
}
