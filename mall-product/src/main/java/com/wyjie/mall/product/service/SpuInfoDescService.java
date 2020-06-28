package com.wyjie.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.mall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:40:43
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

