package com.cloud.sell.service.impl;

import com.cloud.sell.data.ProductCategory;
import com.cloud.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ProductCategoryServiceImpl
 *
 * @Author: yanggy
 * @Description: 商品类目service实现
 * @Date: Created in 2019/8/2 16:01
 * @Mail:
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryService.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryService.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryService.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryService.save(productCategory);
    }
}
