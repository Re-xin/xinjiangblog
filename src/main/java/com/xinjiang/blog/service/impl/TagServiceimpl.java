package com.xinjiang.blog.service.impl;

import com.xinjiang.blog.mapper.TagMapper;
import com.xinjiang.blog.po.Tag;
import com.xinjiang.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/1 2:26
 * @description:
 */
@Service
public class TagServiceimpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveTag(Tag tag) { return tagMapper.saveTag(tag); }

    @Override
    public Tag getTagById(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteTagById(Long id) {
        return tagMapper.deleteTagById(id);
    }
}
