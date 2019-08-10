package com.cloud.sell.service.impl;

import com.cloud.sell.DTO.OrderDTO;
import com.cloud.sell.data.OrderDetail;
import com.cloud.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * OrderServiceImplTest
 *
 * @Author: ygy
 * @Description:
 * @Date: 2019/8/9 22:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID = "Apple-89df8av5dab8";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小明");
        orderDTO.setBuyerPhone("18989898899");
        orderDTO.setBuyerAddress("上海陆家嘴金融中心");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("0001");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}", result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne("1565364987957449740");
        log.info("【查询单个订单】 result={}", orderDTO);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        log.info("【查询订单列表】 result={}", orderDTOPage);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}