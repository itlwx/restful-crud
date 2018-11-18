package com.itlwx.restfulcrud.config;

import com.itlwx.restfulcrud.component.LoginInterceptor;
import com.itlwx.restfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    /*视图映射：将访问主页的路径映射到登录页面*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("login.html");
        registry.addViewController("/index.html").setViewName("login.html");
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("login.html").setViewName("login.html");
        registry.addViewController("main.html").setViewName("dashboard.html");
    }

    /*将自定义的区域信息组件添加到容器*/
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


    /**
     * 注册拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                /*拦截的路径*/
                .addPathPatterns("/**")
                /*不拦截的路径*/
                .excludePathPatterns("/login.html","/","/index","/index.html","/user/login");
    }
}
