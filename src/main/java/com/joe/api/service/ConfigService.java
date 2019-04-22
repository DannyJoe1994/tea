package com.joe.api.service;

import com.joe.api.dao.ConfigMapper;
import com.joe.api.enums.ConfigTypeEnum;
import com.joe.api.po.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置服务
 * create by Joe on 2018-08-07 15:45
 **/
@Service
public class ConfigService {

    @Autowired
    private ConfigMapper configMapper;


    /**
     * 根据配置类型查询
     *
     * @param configTypeEnum
     * @return
     */
    public List<Config> queryConfigByType(ConfigTypeEnum configTypeEnum) {

        if (configTypeEnum == null) {
            return new ArrayList<>();
        }

        return configMapper.queryConfigByType(configTypeEnum.getKey());
    }

    /**
     * 根据配置类型和key查询
     *
     * @param key
     * @param configTypeEnum
     * @return
     */
    public List<Config> queryConfigByTypeAndKey(Integer key, ConfigTypeEnum configTypeEnum) {

        if (key == null || configTypeEnum == null) {
            return new ArrayList<>();
        }

        return configMapper.queryConfigByTypeAndKey(key, configTypeEnum.getKey());
    }
}
