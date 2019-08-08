package com.cloud.sell.service.impl;

import com.cloud.sell.DTO.CartDTO;
import com.cloud.sell.DTO.OrderDTO;
import com.cloud.sell.dao.OrderDetailDao;
import com.cloud.sell.dao.OrderMasterDao;
import com.cloud.sell.dao.ProductInfoDao;
import com.cloud.sell.data.OrderDetail;
import com.cloud.sell.data.OrderMaster;
import com.cloud.sell.data.ProductInfo;
import com.cloud.sell.enums.ResultEnum;
import com.cloud.sell.exception.SellException;
import com.cloud.sell.service.OrderService;
import com.cloud.sell.service.ProductInfoService;
import com.cloud.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderServiceImpl
 *
 * @Author: ygy
 * @Description: 订单ServiceImpl
 * @Date: 2019/8/8 22:43
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1. 查询商品信息
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2. 计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailDao.save(orderDetail);
        }
        //3. 写入数据库（orderMaster 和 orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOpenid(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterDao.save(orderMaster);

        //4. 减库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity()) ).collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);

        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
