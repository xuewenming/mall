package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.mapper.TbItemMapper;
import com.mall.pojo.TbItem;
import com.mall.pojo.TbItemExample;
import com.mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
