package com.wyjie.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.mall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:40:43
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

