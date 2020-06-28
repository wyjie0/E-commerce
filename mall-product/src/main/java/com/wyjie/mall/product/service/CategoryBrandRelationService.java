package com.wyjie.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.mall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:40:43
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    void updateBrand(Long brandId, String name);

    void updateCategory(Long catId, String name);
}

