package com.wyjie.mall.product.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther wyjie
 * @date 2020/6/26 - 周五
 */
@Data
public class AttrRespVo extends AttrVo implements Serializable {

    /**
     * 所属分类名字
     * 如：手机/数码/手机
     */
    private String catelogName;

    /**
     * 所属分组名字
     * 如：主体
     */
    private String groupName;

    /**
     * 完整路径
     */
    private Long[] catelogPath;
    
}
