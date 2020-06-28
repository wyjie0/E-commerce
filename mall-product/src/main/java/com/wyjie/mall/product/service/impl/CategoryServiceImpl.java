package com.wyjie.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyjie.common.utils.PageUtils;
import com.wyjie.common.utils.Query;
import com.wyjie.mall.product.dao.CategoryDao;
import com.wyjie.mall.product.entity.CategoryEntity;
import com.wyjie.mall.product.service.CategoryBrandRelationService;
import com.wyjie.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;
    
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    //查出所有分类，并封装为树形结构
    @Override
    public List<CategoryEntity> listWithTree() {
//        List<CategoryEntity> result = new ArrayList<>();
        //1.查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(
                null);
        //2.组装成父子树形结构
        //2.1找到所有的1级分类
        List<CategoryEntity> level1Menues = categoryEntities.stream().filter(
                (categoryEntity) -> {
                    return categoryEntity.getParentCid() == 0;
                })
                .map((menu)->{
                    menu.setChildren(getChildrens(menu, categoryEntities));
                    return menu;
                })
                .sorted((menu1, menu2)->{
                    return menu1.getSort() - menu2.getSort();
                })
                .collect(Collectors.toList());

        return level1Menues;
    }
    //找到当前菜单的所有子菜单,递归查找
    private List<CategoryEntity> getChildrens(CategoryEntity currentMenu,
                                              List<CategoryEntity> allEntities) {

        List<CategoryEntity> children = new ArrayList<>();
        for (CategoryEntity entity : allEntities) {
            if (entity.getParentCid() == currentMenu.getCatId()) {
                children.add(entity);
                //找到子菜单
                List<CategoryEntity> childrens = getChildrens(entity, allEntities);
                //子菜单排序
                childrens.sort((menu1, menu2)->{
                    return menu1.getSort() - menu2.getSort();
                });
                entity.setChildren(childrens);
            }
        }

        return children;
    }

    /**
     * 批量删除
     * @param asList 要删除内容，以id来标识
     */
    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 检查当前删除的菜单，是否被别的地方引用
        
        //逻辑删除（设置删除标志位）
        baseMapper.deleteBatchIds(asList);
    }
    
    //找到catelogId的完整路径
    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();

        findParentPath(catelogId, paths);
        Collections.reverse(paths);
        Long[] ans = new Long[paths.size()];
        return paths.toArray(ans);
    }

    /**
     * 级联更新所有关联的数据
     * @param category
     */
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    private void findParentPath(Long catelogId, List<Long> paths) {
        paths.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }
        return;
    }
}