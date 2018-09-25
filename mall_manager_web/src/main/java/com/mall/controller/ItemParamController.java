package com.mall.controller;

import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.TaotaoResult;
import com.mall.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 商品分类规格参数模板
 * @author Sam
 * @date 2018/9/25
 * @time 15:40
 */
@Controller
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping(value = "/item/param/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemParam(Integer page,Integer rows) {
        EasyUIDataGridResult result = itemParamService.getItemParamList(page, rows);
        return result;
    }


    @RequestMapping(value = "/item/param/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemParamById(@PathVariable long cid) {
        TaotaoResult itemParamById = itemParamService.getItemParamById(cid);
        return itemParamById;
    }

}
