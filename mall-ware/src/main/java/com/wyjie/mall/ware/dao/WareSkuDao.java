package com.wyjie.mall.ware.dao;

import com.wyjie.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:06:43
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
