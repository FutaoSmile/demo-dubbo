package com.futao.api.model.order;

import com.futao.api.model.IdTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author futao
 * @date 2021/1/6
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends IdTimeEntity {
    private Long userId;
    private Long totalPrice;
    private int status;
}
