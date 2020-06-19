package com.xinjiang.blog.mapper;

import com.xinjiang.blog.po.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/15 4:22
 * @description:
 */
@Mapper
public interface CommentMapper {

    //根据创建时间倒序来排
    @Select("select *\n" +
            "from blog.t_comment c\n" +
            "where c.blog_id = #{blogId} and c.parent_comment_id = #{blogParentId}\n" +
            "order by c.create_time desc")
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    //查询一级回复
    @Select("select *\n" +
            "from blog.t_comment c\n" +
            "where c.blog_id = #{blogId} and c.parent_comment_id = #{id}\n" +
            "order by c.create_time desc")
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);

    //查询二级回复
    @Select("select *\n" +
            "from blog.t_comment c\n" +
            "where c.blog_id = #{blogId} and c.parent_comment_id = #{childId}\n" +
            "order by c.create_time desc")
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId,@Param("childId") Long childId);

    //查询父级对象
    //Comment findByParentCommentId(Long parentCommentId);

    //添加一个评论
    @Insert(" insert into blog.t_comment (nickname,email,content,avatar,create_time,blog_id,parent_comment_id,admin_comment)\n" +
            "        values (#{nickname},#{email},#{content},#{avatar},#{createTime},#{blogId},#{parentCommentId},#{adminComment});")
    boolean saveComment(Comment comment);

    //删除评论
    @Delete("delete from blog.t_comment where id = #{id}")
    boolean deleteComment(Long id);









}
