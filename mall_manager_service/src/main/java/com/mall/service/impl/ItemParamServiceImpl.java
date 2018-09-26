package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.common.pojo.EasyUIDataGridResult;
import com.mall.common.pojo.TaotaoResult;
import com.mall.mapper.TbItemParamMapper;
import com.mall.pojo.TbItemParam;
import com.mall.pojo.TbItemParamExample;
import com.mall.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Sam
 * @date 2018/9/25
 * @time 15:46
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Override
    public EasyUIDataGridResult getItemParamList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        TbItemParamExample example = new TbItemParamExample();
        List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(example);
        PageInfo pageInfo = new PageInfo(tbItemParams);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(tbItemParams);
        return result;
    }

    @Override
    public TaotaoResult getItemParamById(Long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(example);
        if (tbItemParams != null && tbItemParams.size() > 0) {
            return TaotaoResult.ok(tbItemParams);
        }

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult crateItemParam(Long cid, String paramDate) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramDate);
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }


}
