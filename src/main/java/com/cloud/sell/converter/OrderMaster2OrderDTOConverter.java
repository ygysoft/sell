package com.cloud.sell.converter;

import com.cloud.sell.DTO.OrderDTO;
import com.cloud.sell.data.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster2OrderDTOConverter
 *
 * @Author: ygy
 * @Description: orderMaster 转 orderDTO
 * @Date: 2019/8/10 23:21
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList = orderMasterList.stream().map(e ->
                convert(e)
                ).collect(Collectors.toList());
        return orderDTOList;
    }
}
