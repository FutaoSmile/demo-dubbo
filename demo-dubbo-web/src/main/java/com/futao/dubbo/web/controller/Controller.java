package com.futao.dubbo.web.controller;

import com.alibaba.fastjson.JSON;
import com.futao.api.model.order.Order;
import com.futao.api.model.user.User;
import com.futao.api.service.OrderService;
import com.futao.api.service.UserService;
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
@Slf4j
@RestController("controller")
public class Controller {

    @Reference()
    private UserService userService;

    /**
     * check: 在启动时检查服务的可用性
     * init: 是否立即初始化代理对象
     */
    @Reference(check = true,
            init = true
//            , methods = {
//            @Method(name = "listOrderByUserId",
//                    async = true,
//                    oninvoke = "controller.beforeOrders",
//                    onreturn = "controller.afterOrders",
//                    onthrow = "controller.onOrdersThrow")}
    )
    private OrderService orderService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.listUsers();
    }

    @GetMapping("/orders")
    public List<Order> orders(@RequestParam(required = false) Long id) {
        // TODO: 2021/1/8 获取的context里面的值都是空的，why
        RpcContext context = RpcContext.getContext();
        System.out.println(context.getRemoteApplicationName());
        return orderService.listOrderByUserId(id);
    }

    public void beforeOrders(Long id) {
        log.info("beforeOrders:{}", id);
    }

    public void afterOrders(List<Order> orders) {
        log.info("beforeOrders:{}", JSON.toJSONString(orders));
    }

    public void onOrdersThrow(Throwable throwable, Object o) {
        log.info("onOrdersThrow:{}", JSON.toJSONString(o), throwable);
    }
}
