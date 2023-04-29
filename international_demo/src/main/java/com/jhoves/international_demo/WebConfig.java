package com.jhoves.international_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //LocaleChangeInterceptor用于拦截请求并更改应用程序的语言环境（Locale
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }
    @Bean
    //该bean负责解析请求中的语言环境
    LocaleResolver localeResolver() {
        //SessionLocaleResolver将当前用户的语言环境存储在会话（session）中，
        //以便在整个会话期间跟踪用户的首选语言环境
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        return localeResolver;
    }
}
