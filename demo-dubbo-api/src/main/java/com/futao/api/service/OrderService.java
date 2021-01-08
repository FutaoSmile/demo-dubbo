package com.futao.api.service;

import com.futao.api.model.order.Order;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 订单接口
 *
 * @author futao
 * @date 2021/1/6
 */
public interface OrderService {
    /**
     * 根据用户ID查询订单列表
     *
     * @param userId 用户ID
     * @return 订单列表
     */
    List<Order> listOrderByUserId(@NotNull(message = "用户主键不可为空呀！") Long userId);
}
