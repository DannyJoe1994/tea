package com.joe.bussiness.commodity.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.joe.bussiness.base.BaseController;
import com.joe.bussiness.commodity.service.CommodityDetailWebService;
import com.joe.bussiness.commodity.vo.CommodityDetailVO;
import com.joe.util.mvc.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品明细请求
 * create by Joe on 2018-05-29 12:03
 **/

@Controller
@RequestMapping("/commodityDetail")
public class CommodityDetailController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    CommodityDetailWebService commodityDetailWebService;


    @RequestMapping("/getCommodityDetailByCommodityId")
    @ResponseBody
    public Object getCommodityDetailByCommodityId(HttpServletRequest request) {

        String requestParam = getRequestParam(request);
        if (StringUtils.isBlank(requestParam)) {
            return ResponseEntity.getFailEntity("param error");
        }

        JSONObject jsonObject = JSON.parseObject(requestParam);
        Integer commodityId = Integer.valueOf(jsonObject.get("commodityId").toString());

        logger.info("query commodity detail by commodity id, id is {}", commodityId);
        CommodityDetailVO commodityDetailVO = commodityDetailWebService.queryCommodityDetailByCommodityId(commodityId);

        return ResponseEntity.getSuccessEntity(commodityDetailVO);

    }
}