package com.wyjie.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 20:55:29
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

