package com.cloud.sell.VO;

import lombok.Data;

/**
 * ResultVO
 *
 * @Author:ygy
 * @Description:返回的最外层对象
 * @Date: Created in 2019/8/6 11:00
 */
@Data
public class ResultVO<T> {

    /** 应答码 */
    private String code;

    /** 应答信息 */
    private String msg;

    /** 内容 */
    private T data;
}
