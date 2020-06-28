package com.wyjie.mall.member.controller;

import com.wyjie.common.utils.PageUtils;
import com.wyjie.common.utils.R;
import com.wyjie.mall.member.entity.MemberEntity;
import com.wyjie.mall.member.feign.CouponFeignService;
import com.wyjie.mall.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员
 *
 * @author wyjie
 * @email wyjie96@gmail.com
 * @date 2020-06-12 21:09:13
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private CouponFeignService couponFeignService;
    
    @RequestMapping("/coupons")
    public R test() {
        MemberEntity member = new MemberEntity();
        member.setNickname("www");
        R membercoupons = couponFeignService.membercoupons();
        return R.ok().put("member",member).put("coupons",membercoupons.get("coupons"));
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
