package com.futao.dubbo.web;

import com.alibaba.fastjson.JSONObject;
import com.futao.api.model.order.Order;
import com.futao.api.model.user.User;
import com.futao.starter.fustack.utils.TimeUtil;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author futao
 * @date 2021/1/7
 */
@EnableDubbo
@SpringBootApplication
@ServletComponentScan
public class WebApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Autowired
    private FreeMarkerConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    /**
     * Freemarker手动渲染
     */
    private void manualRender() throws IOException, TemplateException {
        User user = new User();
        user.setUsername("ft");
        user.setEnglishName("ft fnatic");
        user.setGender(1);
        ArrayList<Order> orderList = new ArrayList<>(3);
        Order order1 = new Order(1L, 999L, 1);
        order1.setCreateDateTime(TimeUtil.currentLocalDateTime());
        orderList.add(order1);
        Order order2 = new Order(1L, 2999L, 2);
        order2.setCreateDateTime(TimeUtil.currentLocalDateTime().minusMonths(3));
        orderList.add(order2);
        Order order3 = new Order(1L, 9999L, 3);
        order3.setCreateDateTime(TimeUtil.currentLocalDateTime().minusDays(99));
        orderList.add(order3);
        user.setOrderList(orderList);

        Configuration configuration = config.getConfiguration();
        Template indexPage = configuration.getTemplate("indexPage.ftl");
        indexPage.process(new JSONObject().fluentPut("user", user), new BufferedWriter(new FileWriter(new File("./a.html"))));
    }
}
