package com.cloud.sell.utils;

import java.util.Random;

/**
 * KeyUtil
 *
 * @Author: ygy
 * @Description:
 * @Date: 2019/8/8 23:13
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        int r = random.nextInt(900000) + 100000;
        Long time = System.currentTimeMillis();
        return time + String.valueOf(r);
    }
}
