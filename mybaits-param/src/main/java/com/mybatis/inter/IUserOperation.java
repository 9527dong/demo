package com.mybatis.inter;

import com.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by Dong on 2017/5/14.
 */
public interface IUserOperation {
    public User selectUserByID(int id);

    public User selectUserByIdAndUserName(int id, String UserName);

    public User selectUserByIdAndUserNameByAnnotation(@Param("id") int id, @Param("userName") String UserName);

    public User selectUserByMap(Map<String, Object> map);

    public User selectUserByPojo(User user);
}