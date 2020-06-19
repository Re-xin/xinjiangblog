package com.xinjiang.blog.service.impl;

import com.xinjiang.blog.mapper.BlogMapper;
import com.xinjiang.blog.mapper.TypeMapper;
import com.xinjiang.blog.po.Blog;
import com.xinjiang.blog.po.Type;
import com.xinjiang.blog.queryvo.TypeNums;
import com.xinjiang.blog.service.BlogService;
import com.xinjiang.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 21:21
 * @description:
 */
@Service
public class TypeServiceimpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveType(Type type) { return typeMapper.saveType(type); }

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteTypeById(Long id) {
        //删除type，需要先设置blog中type_id为null。没写，以后写
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public List<TypeNums> getAllTypeNum() {
        return typeMapper.getAllTypeNum();
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeMapper.getAllTypeAndBlog();
    }


}
