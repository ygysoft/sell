package com.cloud.sell.service.impl;

import com.cloud.sell.dao.ProductInfoDao;
import com.cloud.sell.data.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ProductInfoServiceImplTest
 *
 * @Author:
 * @Description: 商品信息service测试
 * @Date: Created in 2019/8/6 17:45
 * @Mail:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("0002");
        productInfo.setProductName("牛肉面");
        productInfo.setProductPrice(new BigDecimal(29.9));
        productInfo.setProductIcon("e:/abc/niurou.jpg");
        productInfo.setProductDescription("很多牛肉");
        productInfo.setCategoryType(3);
        productInfo.setProductStock(100);
        productInfo.setProductStatus(0);
        ProductInfo productInfo1 = productInfoDao.save(productInfo);
        Assert.assertNotNull(productInfo);
    }
}
