package com.futao.dubbo.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author futao
 * @date 2021/1/6
 */
@EnableDubbo(scanBasePackages = "com.futao.dubbo.order.service")
@SpringBootApplication
@ServletComponentScan
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
