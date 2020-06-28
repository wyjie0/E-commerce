package com.wyjie.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.common.utils.Query;
import com.wyjie.mall.product.dao.AttrGroupDao;
import com.wyjie.mall.product.entity.AttrGroupEntity;
import com.wyjie.mall.product.service.AttrGroupService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        IPage<AttrGroupEntity> page = null;
        String key = (String) params.get("key");//前端检索条件
        //查询语句：
        //select * from pms_attr_group where catelog_id=catelogId and 
        //                              (attr_group_id=key or attr_group_name like "%key%")
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>();
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((obj) -> {
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }
        
        if (catelogId == 0) {
            page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    wrapper
            );
        } else {
            wrapper.eq("catelog_id", catelogId);
            //按照三级分类查
            page = this.page( 
                    new Query<AttrGroupEntity>().getPage(params),
                    wrapper
            );
        }
        return new PageUtils(page);
    }

}