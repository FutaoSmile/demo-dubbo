package com.futao.api.service;

import com.futao.api.model.order.Order;

import java.util.List;

/**
 * @author futao
 * @date 2021/1/6
 */
public interface OrderService {
    List<Order> listOrderByUserId(Long userId);
}
