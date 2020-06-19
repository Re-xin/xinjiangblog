package com.xinjiang.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinjiang.blog.mapper.BlogMapper;
import com.xinjiang.blog.po.Blog;
import com.xinjiang.blog.po.Comment;
import com.xinjiang.blog.po.Tag;
import com.xinjiang.blog.po.Type;
import com.xinjiang.blog.queryvo.*;
import com.xinjiang.blog.service.BlogService;
import com.xinjiang.blog.service.CommentService;
import com.xinjiang.blog.service.TagService;
import com.xinjiang.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/11 9:30
 * @description:
 */
@Controller
public class indexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){

        PageHelper.startPage(pageNum,10);

        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();
        List<TypeNums> types = typeService.getAllTypeNum();
        List<Tag> tags = tagService.getAllTag();


        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        int totalSize = pageInfo.getList().size();

        model.addAttribute("totalSize",totalSize);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        model.addAttribute("tags", tags);
        return "index";
    }

    //    搜索博客
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 1000);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);

        System.out.println(comments);
        System.out.println(detailedBlog);
        return "blog";
    }

}
