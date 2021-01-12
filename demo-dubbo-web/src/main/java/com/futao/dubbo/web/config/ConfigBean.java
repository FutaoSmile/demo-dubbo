package com.futao.dubbo.web.config;

import com.futao.starter.fustack.auth.auth.impl.LoginUserAuth;
import com.futao.starter.fustack.auth.interceptors.UserAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置中心
 *
 * @author ft
 * @date 2021/1/12
 */
@Configuration
public class ConfigBean {

    @Bean
    public LoginUserAuth loginUserAuth() {
        return new LoginUserAuth();
    }

    @Bean
    public UserAuthInterceptor userAuthInterceptor() {
        return new UserAuthInterceptor();
    }

}
