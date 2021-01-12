package com.futao.api.model.user;

import com.futao.api.model.IdTimeEntity;
import com.futao.api.model.order.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author futao
 * @date 2021/1/6
 */
@Getter
@Setter
public class User extends IdTimeEntity {
    private String username;
    private String englishName;
    private int gender;
    private List<Order> orderList;
}
