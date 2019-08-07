package com.cloud.sell.enums;

import lombok.Getter;

/**
 * OrderStatusEnum
 *
 * @Author: ygy
 * @Description: 订单状态枚举
 * @Date: Created in 2019/8/7 17:33
 * @Mail:
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完成"),
    CANCEL(2, "已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
