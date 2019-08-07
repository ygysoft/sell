package com.cloud.sell.utils;

import com.cloud.sell.VO.ResultVO;

/**
 * ResultVOUtil
 *
 * @Author: ygy
 * @Description:
 * @Date: Created in 2019/8/7 16:01
 * @Mail:
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode("0000");
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(String code, String mag){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(mag);
        return resultVO;
    }
}
