package com.wyjie.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.mall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 20:55:29
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

