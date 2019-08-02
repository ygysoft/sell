package com.cloud.sell.service.impl;

import com.cloud.sell.dao.ProductCategoryDao;
import com.cloud.sell.data.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * ProductCategoryServiceImplTest
 *
 * @Author:
 * @Description: 商品类目service测试
 * @Date: Created in 2019/8/2 18:09
 * @Mail:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryDao.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = productCategoryDao.findAll();
        System.out.println("商品类目数量：" + productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 3);
        List<ProductCategory> productCategoryList = productCategoryDao.findByCategoryTypeIn(list);
        System.out.println(productCategoryList.toString());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(4);
        productCategoryDao.save(productCategory);
    }
}
