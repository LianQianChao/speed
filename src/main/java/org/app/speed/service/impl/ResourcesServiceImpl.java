package org.app.speed.service.impl;

import org.app.speed.mapper.ResourcesMapper;
import org.app.speed.model.pojo.Resources;
import org.app.speed.model.properties.RedisProperties;
import org.app.speed.service.RedisService;
import org.app.speed.service.ResourcesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author LianQianChao
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Resource
    private ResourcesMapper mapper;
    @Resource
    private RedisService<Resources> redisService;
    @Resource
    private RedisProperties redisProperties;

    @Override
    public List<Resources> selectAll() {
        List<Resources> list =  redisService.getList(redisProperties.getKey() + "selectAll");
        if (list.size() == 0) {
            list = mapper.selectAll();
            redisService.setList(redisProperties.getKey() + "selectAll", list, 3600);
        }
        return list;
    }
}
