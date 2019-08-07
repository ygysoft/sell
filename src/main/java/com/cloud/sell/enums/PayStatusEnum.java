package com.cloud.sell.enums;

import lombok.Getter;

/**
 * PayStatusEnum
 *
 * @Author: ygy
 * @Description: 支付状态枚举
 * @Date: Created in 2019/8/7 17:41
 * @Mail:
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
