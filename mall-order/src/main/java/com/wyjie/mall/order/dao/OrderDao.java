package com.wyjie.mall.order.dao;

import com.wyjie.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 20:55:29
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
