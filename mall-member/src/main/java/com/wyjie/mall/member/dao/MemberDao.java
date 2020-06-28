package com.wyjie.mall.member.dao;

import com.wyjie.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:09:13
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
