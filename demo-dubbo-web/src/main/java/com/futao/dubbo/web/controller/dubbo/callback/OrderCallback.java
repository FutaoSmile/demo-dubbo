package com.futao.dubbo.web.controller.dubbo.callback;

import com.futao.api.model.order.Order;

import java.util.List;

/**
 * @author ft
 * @date 2021/1/11
 */
public interface OrderCallback {
    void beforeOrders(Long id);

    void afterOrders(List<Order> orders);

    void onOrdersThrow(Throwable throwable, Object o);
}
