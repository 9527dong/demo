package com.yihaomen.inter;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yihaomen.model.Article;
import com.yihaomen.model.User;
import com.yihaomen.util.PageInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserOperation {
    
	public User selectUserByID(int id);
	public List<User> selectUsers(String userName);	
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	
	public List<Article> getUserArticles(int id);
	
	public List<Article> selectArticleListPage(@Param("page") PageInfo page, @Param("userid") int userid);
	
	
}
