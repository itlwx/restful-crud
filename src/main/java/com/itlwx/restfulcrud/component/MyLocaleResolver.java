package com.itlwx.restfulcrud.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 区域语言信息解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        Locale locale = null;
        if(StringUtils.hasText(lang)){
            //若连接中有指定语言就使用指定的语言
            String[] s = lang.split("_");
            locale = new Locale(s[0],s[1]);
        }else{
            //若没有就根据请求头来确定语言
            String header = request.getHeader("Accept-Language");
            String[] countryAndLang = header.substring(0, header.indexOf(",")).split("-");
            locale = new Locale(countryAndLang[0],countryAndLang[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
