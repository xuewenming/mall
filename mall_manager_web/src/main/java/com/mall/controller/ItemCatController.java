package com.mall.controller;

import com.mall.common.pojo.EasyUITreeResult;
import com.mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类
 * @author Sam
 * @date 2018/9/22
 * @time 11:37
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/item/cat/list")
    @ResponseBody
    public List<EasyUITreeResult> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId) {
        List<EasyUITreeResult> itemCat = itemCatService.getItemCat(parentId);
        return itemCat;
    }
}
