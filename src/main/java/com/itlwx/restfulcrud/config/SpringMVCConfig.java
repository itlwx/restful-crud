package com.itlwx.restfulcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    /*将访问主页的路径映射到登录页面*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("login.html");
        registry.addViewController("/index.html").setViewName("login.html");
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("login.html").setViewName("login.html");
    }

    /*将自定义的区域信息组件添加到容器*/
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
