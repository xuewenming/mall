package com.mall.service;

import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.TaotaoResult;
import com.mall.pojo.TbItem;

/**
 * 商品接口
 * @author Sam
 * @date 2018/9/18
 * @time 20:57
 */
public interface ItemService {
    /**
     * 查询商品
     * @param page 页号
     * @param rows 每页条数
     * @return
     */
    EasyUIDataGridResult getItemList(Integer page, Integer rows);

    /**
     * 创建新商品
     * @param tbItem    商品
     * @param desc 商品描述
     * @return
     */
    TaotaoResult createItem(TbItem tbItem, String desc);
}
