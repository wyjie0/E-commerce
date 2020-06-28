package com.wyjie.mall.product;

import com.wyjie.mall.product.service.BrandService;
import com.wyjie.mall.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    private BrandService brandService;
    
    @Autowired
    CategoryService categoryService;
    
    @Test
    void contextLoads() {

        Long[] catelogPath = categoryService.findCatelogPath(225L);
        System.out.println(catelogPath[0]);
    }

}
