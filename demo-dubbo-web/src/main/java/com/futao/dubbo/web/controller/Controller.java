package com.futao.dubbo.web.controller;

import com.futao.api.model.order.Order;
import com.futao.api.model.user.User;
import com.futao.api.service.OrderService;
import com.futao.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author futao
 * @date 2021/1/7
 */
@RestController
public class Controller {

    @Reference
    private UserService userService;

    @Reference
    private OrderService orderService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.listUsers();
    }

    @GetMapping("/orders")
    public List<Order> orders() {
        return orderService.listOrderByUserId(1L);
    }

}
