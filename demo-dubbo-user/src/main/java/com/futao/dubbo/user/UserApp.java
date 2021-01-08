package com.futao.dubbo.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author futao
 * @date 2021/1/6
 */
@EnableDubbo(scanBasePackages = "com.futao.dubbo.user.service")
@SpringBootApplication
@ServletComponentScan
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}
