package com.cloud.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * WechatAccountConfig
 *
 * @Author: ygy
 * @Description:
 * @Date: 2019/9/2 23:20
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpSecret;

}
