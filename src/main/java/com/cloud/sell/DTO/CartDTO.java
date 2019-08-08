package com.cloud.sell.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * cartDTO
 *
 * @Author: ygy
 * @Description: 购物车
 * @Date: 2019/8/8 23:27
 */
@Data
@AllArgsConstructor
public class CartDTO {

    /** 商品ID */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;
}
