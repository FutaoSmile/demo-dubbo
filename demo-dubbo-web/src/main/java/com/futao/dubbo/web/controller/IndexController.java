package com.futao.dubbo.web.controller;

import com.futao.api.model.order.Order;
import com.futao.api.model.user.User;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import com.futao.starter.fustack.freemarker.methods.LocalDateFormatterMethod;
import com.futao.starter.fustack.freemarker.methods.LocalDateTimeFormatterMethod;
import com.futao.starter.fustack.utils.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * 首页
 *
 * @author ft
 * @date 2021/1/11
 */
@RequestMapping
@Controller
public class IndexController {

    @SkipUserAuth
    @GetMapping({"/index", "/"})
    public ModelAndView index() {
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

        ModelAndView modelAndView = new ModelAndView("indexPage", "user", user);
        modelAndView.addObject("localDateFormatter", new LocalDateFormatterMethod());
        modelAndView.addObject("localDateTimeFormatter", new LocalDateTimeFormatterMethod());
        return modelAndView;
    }
}
