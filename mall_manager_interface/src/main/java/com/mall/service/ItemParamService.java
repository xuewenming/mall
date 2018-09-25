package com.mall.service;

import com.mall.common.pojo.EasyUIDataGridResult;

/**
 * 商品规格模板展示
 * @author Sam
 * @date 2018/9/25
 * @time 15:44
 */
public interface ItemParamService {
    EasyUIDataGridResult getItemParamList(Integer page,Integer pageSize);
}
