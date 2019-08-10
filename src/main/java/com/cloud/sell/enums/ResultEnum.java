package com.cloud.sell.enums;

import lombok.Getter;

/**
 * ResultEnum
 *
 * @Author: ygy
 * @Description: 商品异常信息枚举
 * @Date: 2019/8/8 22:53
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品信息不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),

    ORDER_NOT_EXIST(12, "订单不存在"),

    ORDER_DETAIL_NOT_EXIT(13, "订单详情不存在"),

    ORDER_STATUS_ERROR(14, "订单状态不正确"),

    ORDER_UPDATE_FAIL(15, "订单更改状态失败"),

    ORDER_DETAIL_EMPTY(16, "订单详情为空")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
