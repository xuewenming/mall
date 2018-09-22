package com.mall.service;

import com.mall.common.pojo.EasyUITreeResult;

import java.util.List;

/**
 * 商品类目展示
 * @author Sam
 * @date 2018/9/22
 * @time 11:20
 */
public interface ItemCatService {
    /**
     * 商品类目展示
     * @param pid
     * @return
     */
    List<EasyUITreeResult> getItemCat(long pid);
}
