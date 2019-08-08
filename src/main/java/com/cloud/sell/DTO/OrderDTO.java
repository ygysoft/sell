package com.cloud.sell.DTO;

import com.cloud.sell.data.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * OrderDTO
 *
 * @Author: ygy
 * @Description: 订单传输对象
 * @Date: 2019/8/8 22:34
 */
@Data
public class OrderDTO {

    private String orderId;

    /** 买家姓名 */
    private String buyName;

    /** 买家电话 */
    private String buyPhone;

    /** 买家地址 */
    private String buyAddress;

    /** 买家微信openid */
    private String openid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态 默认0，未支付*/
    private Integer orderStatus;

    /** 支付状态 默认0，未支付*/
    private Integer payStatus;

    /** 创建时间 */
    private Data createTime;

    /** 更新时间 */
    private Data updateTime;

    /** 订单信息列表 */
    private List<OrderDetail> orderDetailList;
}
