package com.futao.dubbo.web.controller.dubbo.callback.impl;

import com.alibaba.fastjson.JSON;
import com.futao.api.model.order.Order;
import com.futao.dubbo.web.controller.dubbo.callback.OrderCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ft
 * @date 2021/1/11
 */
@Slf4j
@Service("orderCallback")
public class OrderCallBackImpl implements OrderCallback {

    @Override
    public void beforeOrders(Long id) {
        log.info("beforeOrders:{}", id);
    }

    @Override
    public void afterOrders(List<Order> orders) {
        log.info("beforeOrders:{}", JSON.toJSONString(orders));
    }

    @Override
    public void onOrdersThrow(Throwable throwable, Object o) {
        log.info("onOrdersThrow:{}", JSON.toJSONString(o), throwable);
    }
}
