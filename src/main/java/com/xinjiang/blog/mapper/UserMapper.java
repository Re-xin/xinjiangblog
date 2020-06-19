package com.xinjiang.blog.mapper;

import com.xinjiang.blog.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 2:25
 * @description:
 */
@Mapper
public interface UserMapper {

    @Select("select * from t_user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(String username,String password);


}
