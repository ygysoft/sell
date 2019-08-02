package com.cloud.sell.dao;

import com.cloud.sell.data.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ProductCategoryDao
 *
 * @Author:
 * @Description: 商品类目dao
 * @Date: Created in 2019/8/1 16:30
 * @Mail:
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypelist);
}
