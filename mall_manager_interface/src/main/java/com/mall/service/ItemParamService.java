package com.mall.service;

import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.TaotaoResult;

/**
 * 商品规格模板展示
 * @author Sam
 * @date 2018/9/25
 * @time 15:44
 */
public interface ItemParamService {
    /**
     * 商品规格查询
     * @param page
     * @param pageSize
     * @return
     */
    EasyUIDataGridResult getItemParamList(Integer page,Integer pageSize);

    /**
     * 查询商品规格是否存在
     * @param cid cat_id
     * @return
     */
    TaotaoResult getItemParamById(Long cid);
}
