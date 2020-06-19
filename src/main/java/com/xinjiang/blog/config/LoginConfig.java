package com.xinjiang.blog.config;

import com.xinjiang.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/5/31 4:30
 * @description: 拦截登陆
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")   //拦截的路径
                .excludePathPatterns("/admin","/admin/login");  //放行的路径
    }
}
