package com.wyjie.mall.coupon.dao;

import com.wyjie.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 22:06:08
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
