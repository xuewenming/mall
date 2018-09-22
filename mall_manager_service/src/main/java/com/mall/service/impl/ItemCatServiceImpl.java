package com.mall.service.impl;

import com.mall.common.pojo.EasyUITreeResult;
import com.mall.mapper.TbItemCatMapper;
import com.mall.pojo.TbItemCat;
import com.mall.pojo.TbItemCatExample;
import com.mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam
 * @date 2018/9/22
 * @time 11:23
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeResult> getItemCat(long pid) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        List<EasyUITreeResult> EasyUITreeResultList = new ArrayList<>();
        for (TbItemCat tbItemCat:
        tbItemCats) {
            EasyUITreeResult result = new EasyUITreeResult();
            result.setId(tbItemCat.getId());
            result.setText(tbItemCat.getName());
            result.setState(tbItemCat.getIsParent()?"closed":"open");
            EasyUITreeResultList.add(result);
        }
        return EasyUITreeResultList;
    }
}
