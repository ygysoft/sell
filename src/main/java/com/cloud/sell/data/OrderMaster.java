package com.cloud.sell.data;

import com.cloud.sell.enums.OrderStatusEnum;
import com.cloud.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderMaster
 *
 * @Author: ygy
 * @Description: 订单主表实体
 * @Date: Created in 2019/8/7 17:26
 * @Mail:
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    /** 买家姓名 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态 默认0，未支付*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态 默认0，未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

}
