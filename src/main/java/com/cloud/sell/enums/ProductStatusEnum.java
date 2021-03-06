package com.cloud.sell.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"正常"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
