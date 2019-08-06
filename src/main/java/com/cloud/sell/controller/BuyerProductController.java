package com.cloud.sell.controller;

import com.cloud.sell.VO.ProductInfoVO;
import com.cloud.sell.VO.ProductVO;
import com.cloud.sell.VO.ResultVO;
import com.cloud.sell.data.ProductCategory;
import com.cloud.sell.data.ProductInfo;
import com.cloud.sell.service.ProductCategoryService;
import com.cloud.sell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BuyerProductController
 *
 * @Author: ygy
 * @Description: 买家商品
 * @Date: Created in 2019/8/6 10:52
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.查询类目
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3.拼装数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory prductCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(prductCategory.getCategoryType());
            productVO.setCategoryName(prductCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(prductCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        resultVO.setData(productVOList);
        resultVO.setCode("0000");
        resultVO.setMsg("成功");

        return resultVO;
    }

}
