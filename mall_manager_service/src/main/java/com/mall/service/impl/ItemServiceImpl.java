package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.IDUtils;
import com.mall.common.pojo.TaotaoResult;
import com.mall.mapper.TbItemDescMapper;
import com.mall.mapper.TbItemMapper;
import com.mall.mapper.TbItemParamItemMapper;
import com.mall.pojo.TbItem;
import com.mall.pojo.TbItemDesc;
import com.mall.pojo.TbItemExample;
import com.mall.pojo.TbItemParamItem;
import com.mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Sam
 * @date 2018/9/18
 * @time 20:59
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);

        TbItemExample example = new TbItemExample();
        List<TbItem> tbItems = itemMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(tbItems);

        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(tbItems);
        return result;
    }

    @Override
    public TaotaoResult createItem(TbItem tbItem, String desc,String itemParams) {
        long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        //商品状态1-正常，2-下架，3-删除
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());

        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParams);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());

        itemMapper.insert(tbItem);
        itemDescMapper.insert(itemDesc);
        itemParamItemMapper.insert(itemParamItem);
        return TaotaoResult.ok();
    }
}
