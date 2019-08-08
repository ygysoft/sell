package com.cloud.sell.exception;

import com.cloud.sell.enums.ResultEnum;

/**
 * SellException
 *
 * @Author: ygy
 * @Description: 商品异常类
 * @Date: 2019/8/8 22:51
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = code;
    }
}
