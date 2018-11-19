package com.itlwx.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    /*@RequestParam：用于明确指定参数从请求中获取，请求中若没有将报错*/
    @PostMapping(value ="/user/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Map<String,Object> map, HttpSession session){

        if(StringUtils.hasText(password) && "123".equals(password)){
            session.setAttribute("loginUser",username);
            //重定向到主页，防止表单重复提交（若使用转发，到主页面刷新时将会发生表单重复提交的问题）
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
