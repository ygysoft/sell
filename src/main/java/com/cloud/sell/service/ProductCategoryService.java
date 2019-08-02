package com.cloud.sell.service;

import com.cloud.sell.data.ProductCategory;

import java.util.List;

/**
 * ProductCategoryService
 *
 * @Author: yanggy
 * @Description: 类目service接口
 * @Date: Created in 2019/8/2 15:56
 * @Mail:
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
