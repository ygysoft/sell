package com.cloud.sell.service;

import com.cloud.sell.data.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * productInfoService
 *
 * @Description:
 * @Author: ygy
 * @Date: 2019/8/5 22:27
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findUpAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     */

    /**
     * 减库存
     */
}
