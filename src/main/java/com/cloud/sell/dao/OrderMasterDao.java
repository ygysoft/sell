package com.cloud.sell.dao;

import com.cloud.sell.data.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderMasterDao
 *
 * @Author: ygy
 * @Description:
 * @Date: Created in 2019/8/7 18:00
 * @Mail:
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
