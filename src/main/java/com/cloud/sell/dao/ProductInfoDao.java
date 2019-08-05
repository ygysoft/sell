package com.cloud.sell.dao;

import com.cloud.sell.data.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * productInfoDao
 *
 * @Description:
 * @Author: ygy
 * @Date: 2019/8/5 22:27
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
