package com.xinjiang.blog.service.impl;

import com.xinjiang.blog.mapper.UserMapper;
import com.xinjiang.blog.po.User;
import com.xinjiang.blog.service.UserService;
import com.xinjiang.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 2:16
 * @description:
 */
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, MD5Utils.code(password));
    }
}
