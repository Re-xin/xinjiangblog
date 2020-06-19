package com.xinjiang.blog.mapper;

import com.xinjiang.blog.po.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/1 2:27
 * @description:
 */
@Mapper
public interface TagMapper {

    @Select("select * from t_tag where name = #{name}")
    Tag getTagByName(String name);

    @Insert("insert into t_tag (name) values(#{name})")
    boolean saveTag(Tag tag);

    @Select("select * from t_tag where id = #{id}")
    Tag getTagById(Long id);

    @Select("select * from t_tag")
    List<Tag> getAllTag();

    @Update("update t_tag set name = #{name} WHERE id = #{id}")
    boolean updateTag(Tag tag);

    @Delete("delete from t_tag where id = #{id}")
    boolean deleteTagById(Long id);
}
