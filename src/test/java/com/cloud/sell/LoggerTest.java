package com.cloud.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * LoggerTest
 *
 * @Author:
 * @Description:
 * @Date: Created in 2019/8/1 15:39
 * @Mail:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1(){
        String name = "cloud";
        String password = "123456";
        log.debug("debug...");
        log.info("name:{}, password:{}", name, password);
        log.error("error...");
    }
}
