package com.cloud.sell.service.impl;

import com.cloud.sell.DTO.OrderDTO;
import com.cloud.sell.enums.ResultEnum;
import com.cloud.sell.exception.SellException;
import com.cloud.sell.service.BuyerService;
import com.cloud.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BuyerServiceImpl
 *
 * @Author: ygy
 * @Description:
 * @Date: 2019/8/26 21:48
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO != null && !openid.equalsIgnoreCase(orderDTO.getBuyerOpenid())){
            log.error("【查询订单】订单的openid不一致，openid={}",orderDTO.getBuyerOpenid());
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            log.error("【取消订单】查不到该订单，openid={}",openid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(!openid.equalsIgnoreCase(orderDTO.getBuyerOpenid())){
            log.error("【查询订单】订单的openid不一致，openid={}",orderDTO.getBuyerOpenid());
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        OrderDTO cancelOrderDTO = orderService.cancel(orderDTO);
        return cancelOrderDTO;
    }
}
