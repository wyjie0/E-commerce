package com.wyjie.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:09:13
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

