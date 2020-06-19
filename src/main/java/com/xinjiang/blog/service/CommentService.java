package com.xinjiang.blog.service;

import com.xinjiang.blog.po.Comment;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/15 4:21
 * @description:
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    boolean saveComment(Comment comment);

//    查询子评论
//    List<Comment> getChildComment(Long blogId,Long id);

    //删除评论
    boolean deleteComment(Comment comment,Long id);

}
