package com.cloud.sell.dao;

import com.cloud.sell.data.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * ProductCategoryDaoTest
 *
 * @Author:
 * @Description:
 * @Date: Created in 2019/8/1 16:38
 * @Mail:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("今日优选");
        productCategory.setCategoryType(001);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void update(){
        ProductCategory productCategory = productCategoryDao.findById(1).orElse(null);
        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }
}
