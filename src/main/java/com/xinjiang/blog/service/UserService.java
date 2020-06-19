package com.xinjiang.blog.service;

import com.xinjiang.blog.po.User;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 2:16
 * @description:
 */
public interface UserService {

    User checkUser(String username,String password);
}
