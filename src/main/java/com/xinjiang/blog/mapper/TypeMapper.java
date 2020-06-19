package com.xinjiang.blog.mapper;

import com.xinjiang.blog.po.Type;
import com.xinjiang.blog.queryvo.TypeNums;
import org.apache.ibatis.annotations.*;
import org.springframework.data.annotation.QueryAnnotation;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 21:23
 * @description:
 */
@Mapper
public interface TypeMapper {

    @Select("select * from t_type where name = #{name}")
    Type getTypeByName(String name);

    @Insert("insert into t_type (name) values(#{name})")
    boolean saveType(Type type);

    @Select("select * from t_type where id = #{id}")
    Type getTypeById(Long id);

    @Select("select * from t_type")
    List<Type> getAllType();

    @Update("update t_type set name = #{name} WHERE id = #{id}")
    boolean updateType(Type type);

    @Delete("delete from t_type where id = #{id}")
    boolean deleteTypeById(Long id);

    @Select("SELECT t_blog.type_Id,t_type.name,COUNT(*) AS nums \n" +
            "FROM t_type  \n" +
            "INNER JOIN t_blog\n" +
            "ON t_blog.type_Id = t_type.id\n" +
            "GROUP BY t_blog.type_id,t_type.name\n" +
            "ORDER BY nums DESC")
    List<TypeNums> getAllTypeNum();

    @Select("select t.id id, t.name, b.id bid, b.title,b.type_id from blog.t_type t,blog.t_blog b where t.id = b.type_id")
    List<Type> getAllTypeAndBlog();
}
