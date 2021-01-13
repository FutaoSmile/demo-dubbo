package com.futao.dubbo.web.controller;

import com.alibaba.fastjson.JSON;
import com.futao.api.model.order.Order;
import com.futao.api.model.user.User;
import com.futao.api.service.OrderService;
import com.futao.api.service.UserService;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author futao
 * @date 2021/1/7
 */
@SkipUserAuth
@Slf4j
@RestController("controller")
public class Controller {

    @Reference(stub = "com.futao.dubbo.web.service.UserServiceImpl")
    private UserService userService;

    /**
     * check: 在启动时检查服务的可用性
     * init: 是否立即初始化代理对象
     */
    @Reference(check = true,
            init = true
            , methods = {
            @Method(name = "listOrderByUserId",
                    async = true,
                    oninvoke = "orderCallback.beforeOrders",
                    onreturn = "orderCallback.afterOrders",
                    onthrow = "orderCallback.onOrdersThrow")}
    )
    private OrderService orderService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.listUsers();
    }

    @SkipUserAuth
    @GetMapping("/orders")
    public List<Order> orders(@RequestParam(required = false) Long id) {
        RpcContext context = RpcContext.getContext();
        System.out.println(context.getRemoteApplicationName());
        List<Order> orders = orderService.listOrderByUserId(id);
        // 调用之后才有值
        RpcContext context2 = RpcContext.getContext();
        System.out.println(context2.getRemoteApplicationName());
        return orders;
    }


}
