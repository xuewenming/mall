package com.mall.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.mapper.TbItemMapper;
import com.mall.pojo.TbItem;
import com.mall.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试PageHelper
 * @author Sam
 * @date 2018/9/18
 * @time 20:04
 */
public class TestPageHelper {

    @Test
    public void testPageHelper() {
        //1.初始化Spring容器加载Mapper
        ApplicationContext context
                = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //2.获得Mapper代理对象
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        //3.设置分页信息
        PageHelper.startPage(1,10);

        //4.查询
        TbItemExample example = new TbItemExample();//设置查询条件时使用
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        List<TbItem> tbItems2 = itemMapper.selectByExample(example);

        //5.使用PageInfo,获取查询后的信息
        PageInfo pinfo = new PageInfo(tbItems);


        System.out.println("getTotal() ===" + pinfo.getTotal());
        System.out.println("getPages() ===" +pinfo.getPages());
        System.out.println("getPageNum() ===" +pinfo.getPageNum());
        System.out.println("getPageSize() ===" +pinfo.getPageSize());




        System.out.println("pageHepler会对紧跟着的第一条查询进行分页：" + tbItems.size());
        System.out.println("pageHepler不会对第二条查询进行分页：" +tbItems2.size());

        //6.遍历结果集
        for (TbItem item:
                tbItems) {
            System.out.println( item.getTitle() + "====>" );
        }
    }

}
