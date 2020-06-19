package com.xinjiang.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinjiang.blog.po.Blog;
import com.xinjiang.blog.po.User;
import com.xinjiang.blog.queryvo.BlogQuery;
import com.xinjiang.blog.queryvo.SearchBlog;
import com.xinjiang.blog.queryvo.ShowBlog;
import com.xinjiang.blog.service.BlogService;
import com.xinjiang.blog.service.TagService;
import com.xinjiang.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 4:18
 * @description:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    //博客列表
    @RequestMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按照排序字段 倒序 排序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<BlogQuery> list = blogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }

    //搜索博客
    @PostMapping("/blogs/search")
    public String search(SearchBlog searchBlog, Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
        PageHelper.startPage(pageNum, 10);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs :: blogList";
    }

    //跳转博客新增页面
    @GetMapping("blogs/input")
    public String input(Model model){
        model.addAttribute("types",typeService.getAllType());
//        model.addAttribute("tags",tagService.getAllTag());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    @PostMapping("blogs")
    public String post(Blog blog,RedirectAttributes attributes, HttpSession session) {
        //设置blog中的user
        blog.setUser((User) session.getAttribute("user"));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        //是否新增成功
        boolean flag = blogService.saveBlog(blog);
        System.out.println(blog);
        if (flag) {
            attributes.addFlashAttribute("message", "新增成功");
        } else {
            attributes.addFlashAttribute("message", "新增失败");
        }
        return "redirect:/admin/blogs";
    }


    //跳转博客修改页面
    @GetMapping("blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("blog",blogService.getBlogById(id));
        return "admin/blogs-input";
    }

    //    编辑修改博客
    @PostMapping("/blogs/{id}")
    public String editPost(@Validated ShowBlog showBlog, RedirectAttributes attributes) {
        boolean flag = blogService.updateBlog(showBlog);
        if(flag){
            attributes.addFlashAttribute("message", "修改成功");
        }else {
            attributes.addFlashAttribute("message", "修改失败");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        boolean flag = blogService.deleteBlog(id);
        if (flag){
            attributes.addFlashAttribute("message", "删除成功");
        }else {
            attributes.addFlashAttribute("message", "修改失败");
        }
        return "redirect:/admin/blogs";
    }

}
