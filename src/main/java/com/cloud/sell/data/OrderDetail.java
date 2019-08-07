package com.cloud.sell.data;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * OrderDetail
 *
 * @Author: ygy
 * @Description: 订单详情实体
 * @Date: Created in 2019/8/7 17:48
 * @Mail:
 */
@Entity
@Data
public class OrderDetail {

    private String detailId;

    /** 订单id */
    private String orderId;

    /** 商品id */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer quantity;

    /** 商品小图 */
    private String productIcon;
}
