package com.wyjie.mall.product.controller;

import com.wyjie.common.utils.PageUtils;
import com.wyjie.common.utils.R;
import com.wyjie.mall.product.service.AttrService;
import com.wyjie.mall.product.vo.AttrRespVo;
import com.wyjie.mall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 商品属性
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:40:43
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;
    
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String, Object> params, 
                          @PathVariable("catelogId") Long catelogId,
                          @PathVariable("attrType") String type) {
        
        PageUtils page = attrService.queryBaseAttrPage(params, catelogId, type);
        
        return R.ok().put("page", page);
    }
    
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);
        
        AttrRespVo attrRespVo = attrService.getAttrInfo(attrId);
        return R.ok().put("attr", attrRespVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
        System.out.println("save:" + attr.getValueType());
        attrService.saveAttr(attr);
        return R.ok();
    }

    /**
     * 修改   
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr){
        System.out.println("update:" + attr.getValueType());
		attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
