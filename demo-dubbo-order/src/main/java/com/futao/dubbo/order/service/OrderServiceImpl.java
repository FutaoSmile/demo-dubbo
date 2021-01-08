package com.futao.dubbo.order.service;

import com.futao.api.model.order.Order;
import com.futao.api.service.OrderService;
import org.apache.dubbo.config.annotation.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * @author futao
 * @date 2021/1/7
 */
//@Service(version = "1.0.0", retries = 3, timeout = 3000)
@Service
@org.springframework.stereotype.Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> listOrderByUserId(Long userId) {
        return Arrays.asList(new Order(), new Order());
    }
}
