package com.joe.controller;


import com.joe.common.ApiParameter;
import com.joe.common.ApiResult;
import com.joe.common.wx.service.WxService;
import com.joe.dto.wx.UnifiedParam;
import com.joe.dto.wx.WxAuthParam;
import com.joe.dto.wx.WxLoginDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"微信接口"})
@RestController
@RequestMapping("/wx")
public class WXController {

    @Autowired
    private WxService wxService;


    /**
     * 微信授权
     */
    @PostMapping("/wePayUnified")
    @ApiOperation(value = "订单微信支付", notes = "微信统一支付")
    public ApiResult wxLoginAuthorization(@RequestBody ApiParameter<WxAuthParam> authParam) {

        WxLoginDto wxLoginDto = wxService.wxLoginAuthorization(authParam.getBody().getCode());
        return ApiResult.getSuccessEntity(wxLoginDto);
    }

    /**
     * 微信统一支付
     */
    @PostMapping("/wePayUnified")
    @ApiOperation(value = "订单微信支付", notes = "微信统一支付")
    public ApiResult wePayUnifiedOrder(@RequestBody ApiParameter<UnifiedParam> apiParameter) {

        UnifiedParam param = apiParameter.getBody();
        log.info("微信支付-统一支付，请求参数：{}。", param);

        Object o = wxService.wePayUnifiedOrder(param);
        return ApiResult.getSuccessEntity(o);
    }

    /**
     * 微信回调接口
     */
    @PostMapping("/wxResend")
    @ApiOperation(value = "微信回调接口", notes = "微信回调通知")
    public void wxResend() {

    }


}


