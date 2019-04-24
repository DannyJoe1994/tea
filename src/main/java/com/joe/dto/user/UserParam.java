package com.joe.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserParam {

    //微信授权code
    @ApiModelProperty(value = "授权code", example = "873EBD3FDE8178CDE0530100007F0723")
    private String code;
}
