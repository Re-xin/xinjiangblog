package com.xinjiang.blog.service;

import com.xinjiang.blog.po.Type;
import com.xinjiang.blog.queryvo.TypeNums;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;
//import org.springframework.data.domain.Page;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 21:11
 * @description:
 */
public interface TypeService {

    Type getTypeByName(String name);

    boolean saveType(Type type);

    Type getTypeById(Long id);

    List<Type> getAllType();

    boolean updateType(Type type);

    boolean deleteTypeById(Long id);

    List<TypeNums> getAllTypeNum();

    List<Type> getAllTypeAndBlog();
}
