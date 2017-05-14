package com.yihaomen.mybatis.inter;

import com.yihaomen.mybatis.model.User;

/**
 * Created by Dong on 2017/5/14.
 */
public interface IUserOperation {
    public User selectUserByID(int id);

}