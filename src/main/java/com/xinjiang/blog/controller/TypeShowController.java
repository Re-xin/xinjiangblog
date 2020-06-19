package com.xinjiang.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinjiang.blog.po.Type;
import com.xinjiang.blog.queryvo.FirstPageBlog;
import com.xinjiang.blog.queryvo.TypeNums;
import com.xinjiang.blog.service.BlogService;
import com.xinjiang.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/17 22:27
 * @description:
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    //    分页查询分类
    @GetMapping("/types/{id}")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @PathVariable Long id, Model model) {
//        List<Type> types = typeService.getAllTypeAndBlog();
        List<TypeNums> types = typeService.getAllTypeNum();

        //-1表示从首页导航点进来的
        if (id == -1) {
//            id = types.get(0).getId();
            id = types.get(0).getTypeId();

        }
        model.addAttribute("types", types);
        List<FirstPageBlog> blogs = blogService.getByTypeId(id);

        PageHelper.startPage(pageNum, 10000);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}