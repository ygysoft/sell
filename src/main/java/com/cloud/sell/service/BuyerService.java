package com.cloud.sell.service;

import com.cloud.sell.DTO.OrderDTO;

/**
 * BuyerService
 *
 * @Author: ygy
 * @Description: 买家service
 * @Date: 2019/8/26 21:46
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
