package com.xinjiang.blog.service;

import com.xinjiang.blog.po.Tag;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/1 2:25
 * @description:
 */
public interface TagService {

    Tag getTagByName(String name);

    boolean saveTag(Tag tag);

    Tag getTagById(Long id);

    List<Tag> getAllTag();

    boolean updateTag(Tag tag);

    boolean deleteTagById(Long id);
}
