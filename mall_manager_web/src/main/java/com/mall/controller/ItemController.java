package com.mall.controller;

import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.TaotaoResult;
import com.mall.pojo.TbItem;
import com.mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品查询
 *
 * @author Sam
 * @date 2018/9/18
 * @time 19:04
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }

    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem tbItem, String desc,String itemParams) {
        TaotaoResult result = itemService.createItem(tbItem, desc,itemParams);
        return result;
    }

}
