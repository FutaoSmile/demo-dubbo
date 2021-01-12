package com.futao.dubbo.web.controller;

import com.futao.api.model.order.Order;
import com.futao.api.model.user.User;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
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
        orderList.add(new Order(1L, 999L, 1));
        orderList.add(new Order(1L, 2999L, 2));
        orderList.add(new Order(1L, 9999L, 3));
        user.setOrderList(orderList);
        return new ModelAndView("indexPage", "user", user);
    }
}
