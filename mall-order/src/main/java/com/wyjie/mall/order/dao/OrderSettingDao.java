package com.wyjie.mall.order.dao;

import com.wyjie.mall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 20:55:29
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
