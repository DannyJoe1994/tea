package com.joe.business.commodity.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.joe.api.po.Commodity;
import com.joe.business.base.BaseController;
import com.joe.business.commodity.service.CommodityWebService;
import com.joe.business.commodity.vo.CommodityVo;
import com.joe.util.mvc.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commodity")
public class CommodityController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private CommodityWebService commodityWebService;


    @RequestMapping("/addCommodity")
    @ResponseBody
    public Object addCommodity(HttpServletRequest request) {

        String requestParam = getRequestParam(request);
        if (StringUtils.isBlank(requestParam)) {
            return ResponseEntity.getFailEntity("参数错误");
        }

        CommodityVo commodityVo = JSON.parseObject(requestParam, CommodityVo.class);

        logger.info("新增商品，商品名称:{}", commodityVo.getpName());
        int commodityId = commodityWebService.addCommodity(commodityVo);
        logger.info("新增商品成功,商品Id：{}", commodityId);

        return ResponseEntity.getSuccessEntity("新增商品成功",commodityId);
    }


    /**
     * 根据类目id查询商品集合
     *
     * @param request
     * @return
     */
    @RequestMapping("/getCommodityListByItemId")
    @ResponseBody
    public Object getCommodityListByItemId(HttpServletRequest request) {

        String requestParam = getRequestParam(request);
        if (StringUtils.isBlank(requestParam)) {
            return ResponseEntity.getFailEntity("param error");
        }

        JSONObject jsonObject = JSON.parseObject(requestParam);
        Integer itemId = Integer.valueOf(jsonObject.get("itemId").toString());
        Integer pageNo = Integer.valueOf(jsonObject.get("pageNo").toString());
        Integer pageSize = Integer.valueOf(jsonObject.get("pageSize").toString());
        logger.info("查询商品列表，查询条件：类目编号：{}，页码：{}，每页大小：{}。", itemId, pageNo, pageSize);

        int total = commodityWebService.queryCommodityCountByItemId(itemId);
        List<Commodity> commodityList = commodityWebService.queryCommodityByItemId(itemId, pageNo, pageSize);

        logger.info("查询商品列表结束");
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("contents", commodityList);

        return ResponseEntity.getSuccessEntity("请求成功",data);
    }


    /**
     * 获取推荐商品
     *
     * @return
     */
    @RequestMapping("/getRecommendCommodity")
    @ResponseBody
    public Object getRecommendCommodity() {

        logger.info("查询推荐商品");
        List<Commodity> commodities = commodityWebService.queryRecommendCommodity();
        logger.info("查询推荐商品，商品数量：{}", commodities.size());
        return ResponseEntity.getSuccessEntity("请求成功",commodities);
    }


    @RequestMapping("/switchCommodityRecommend")
    @ResponseBody
    public Object switchCommodityRecommend(HttpServletRequest request) {

        String requestParam = getRequestParam(request);
        if (StringUtils.isBlank(requestParam)) {
            return ResponseEntity.getFailEntity("param error");
        }

        JSONObject jsonObject = JSON.parseObject(requestParam);
        Integer commodityId = Integer.valueOf(jsonObject.get("commodityId").toString());
        logger.info("修改商品状态，商品编号：{}", commodityId);

        int i = commodityWebService.updateRecommendStatus(commodityId);

        if (i > 0) {
            logger.info("修改商品推荐状态成功");
            return ResponseEntity.getSuccessEntity("请求成功",i);
        }

        logger.info("修改商品推荐状态失败");
        return ResponseEntity.getFailEntity("修改商品推荐状态失败");

    }


    /**
     * 删除商品
     *
     * @param request
     * @return
     */
    @RequestMapping("/removeCommodity")
    @ResponseBody
    public Object removeCommodity(HttpServletRequest request) {

        String requestParam = getRequestParam(request);
        if (StringUtils.isBlank(requestParam)) {
            return ResponseEntity.getFailEntity("param error");
        }

        JSONObject jsonObject = JSON.parseObject(requestParam);
        Integer commodityId = Integer.valueOf(jsonObject.get("commodityId").toString());

        commodityWebService.removeCommodity(commodityId);
        return ResponseEntity.getSuccessEntity("删除成功","");
    }

    /**
     * 修改商品
     *
     * @param request
     * @return
     */
    @RequestMapping("/updateCommodity")
    @ResponseBody
    public Object updateCommodity(HttpServletRequest request) {
        String requestParam = getRequestParam(request);
        if (StringUtils.isBlank(requestParam)) {
            return ResponseEntity.getFailEntity("param error");
        }
        CommodityVo commodityVo = JSON.parseObject(requestParam, CommodityVo.class);

        logger.info("修改商品，商品编号：{}", commodityVo.getpId());
        int i = commodityWebService.updateCommodity(commodityVo);

        if(i>0){
            logger.info("修改商品成功");
            return ResponseEntity.getSuccessEntity("修改成功",i);
        }
        logger.info("修改商品失败");
        return ResponseEntity.getFailEntity("修改商品失败");
    }


}