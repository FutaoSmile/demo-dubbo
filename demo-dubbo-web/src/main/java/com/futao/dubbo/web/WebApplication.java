package com.futao.dubbo.web;

import com.futao.starter.fustack.auth.auth.impl.LoginUserAuth;
import com.futao.starter.fustack.auth.interceptors.UserAuthInterceptor;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author futao
 * @date 2021/1/7
 */
@EnableDubbo
@SpringBootApplication
@ServletComponentScan
public class WebApplication implements WebMvcConfigurer {
    @Autowired
    private UserAuthInterceptor userAuthInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("classpath:/templates/freemarker/common/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthInterceptor).addPathPatterns("/**");
    }

    @Bean
    public LoginUserAuth loginUserAuth() {
        return new LoginUserAuth();
    }

    @Bean
    public UserAuthInterceptor userAuthInterceptor() {
        return new UserAuthInterceptor();
    }
}
