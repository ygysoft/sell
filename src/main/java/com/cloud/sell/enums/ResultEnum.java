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

    PRODUCT_STOCK_ERROR(11, "商品库存不正确");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
