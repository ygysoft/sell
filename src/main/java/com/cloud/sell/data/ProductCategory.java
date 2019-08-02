package com.cloud.sell.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ProductCategory
 *
 * @Description: 商品类目
 * @Date: Created in 2019/8/1 16:21
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate
public class ProductCategory {
    /** 类目id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名称 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;
}
