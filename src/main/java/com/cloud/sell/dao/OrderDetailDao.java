package com.cloud.sell.dao;

import com.cloud.sell.data.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * OrderDetailDao
 *
 * @Author: ygy
 * @Description:
 * @Date: Created in 2019/8/7 18:07
 * @Mail:
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
