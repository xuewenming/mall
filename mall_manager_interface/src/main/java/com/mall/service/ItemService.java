package com.mall.service;

import com.mall.common.pojo.EasyUIDataGridResult;

/**
 * 商品接口
 * @author Sam
 * @date 2018/9/18
 * @time 20:57
 */
public interface ItemService {
    /**
     * 查询商品
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGridResult getItemList(Integer page, Integer rows);
}
