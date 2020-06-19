package com.xinjiang.blog.service;

import com.xinjiang.blog.po.Blog;
import com.xinjiang.blog.queryvo.*;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/3 4:01
 * @description:
 */
public interface BlogService {

    ShowBlog getBlogById(Long id);

    List<BlogQuery> getAllBlog();

    boolean saveBlog(Blog blog);

    boolean updateBlog(ShowBlog showBlog);

    boolean deleteBlog(Long id);

    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog();

//    List<FirstPageBlog> getNewBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();


}
