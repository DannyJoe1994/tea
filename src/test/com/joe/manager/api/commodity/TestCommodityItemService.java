package com.joe.manager.api.commodity;


import com.alibaba.fastjson.JSON;
import com.joe.api.po.CommodityItem;
import com.joe.api.service.CommodityItemService;
import com.joe.manager.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestCommodityItemService extends BaseTest {

    @Autowired
    CommodityItemService commodityItemService;


    @Test
    public void testAdd() {

        CommodityItem commodityItem = new CommodityItem();
        commodityItem.setName("张一元");
        commodityItem.setParentId(5);
        commodityItem.setParentIds("0,1,5");
        commodityItem.setCreateBy(1);
        commodityItem.setUpdateBy(1);
        int i = commodityItemService.addCommodityItem(commodityItem);
        System.out.println(i);

    }


    @Test
    public void testSelect() {

        CommodityItem commodityItem = commodityItemService.queryCommodityItemById(1);
        logger.info("id为1的类目：{}",commodityItem);

        CommodityItem commodityItem1 = commodityItemService.queryCommodityItemByName("茶叶");
        logger.info("名字为茶叶的类目：{}",commodityItem1);

    }


    @Test
    public void testSelectItemIds(){

        List<Integer> list = commodityItemService.selectSubItemIdList(4);
        logger.info("id为4的下级类目集合：{}",JSON.toJSONString(list));

    }


}
