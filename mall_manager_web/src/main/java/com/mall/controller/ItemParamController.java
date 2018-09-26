package com.mall.controller;

import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.TaotaoResult;
import com.mall.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品分类规格参数模板
 * @author Sam
 * @date 2018/9/25
 * @time 15:40
 */
@Controller
@RequestMapping(value = "/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemParam(Integer page,Integer rows) {
        EasyUIDataGridResult result = itemParamService.getItemParamList(page, rows);
        return result;
    }


    @RequestMapping(value = "/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemParamById(@PathVariable long cid) {
        TaotaoResult itemParamById = itemParamService.getItemParamById(cid);
        return itemParamById;
    }

    @RequestMapping(value = "/save/{cid}",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItemParam(@PathVariable Long cid,String paramData) {
        TaotaoResult result = itemParamService.crateItemParam(cid, paramData);
        return result;
    }

}
