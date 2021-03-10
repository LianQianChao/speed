package org.app.speed.service.impl;

import org.app.speed.constant.enums.StatusEnum;
import org.app.speed.exception.DefinitionException;
import org.app.speed.mapper.LogMapper;
import org.app.speed.model.pojo.Log;
import org.app.speed.model.properties.RedisProperties;
import org.app.speed.service.inft.LogService;
import org.app.speed.service.inft.RedisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试Redis
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private RedisProperties redisProperties;

    @Override
    public List<Log> selectLog() {
        final String LOG_KEY = "all_logs";
        final String KEY = redisProperties.getKey() + LOG_KEY;
        if (redisService.getList(KEY).size() == 0) {
            System.out.println("---加入缓存");
            List<Log> list = logMapper.selectLog();
            redisService.setList(KEY, list, 120);
            return list;
        } else {
            System.out.println("---获取缓存");
            return redisService.getList(KEY);
        }

    }

    @Override
    public Log selectLogById(Integer id) {
        final String KEY = redisProperties.getKey() + id;
        if (redisService.get(KEY) == null) {
            System.out.println("---加入缓存");
            Log log = logMapper.selectLogById(id);
            redisService.set(KEY, log);
            return log;
        } else {
            System.out.println("---获取缓存");
            return (Log) redisService.get(KEY);
        }
    }

    @Transactional
    @Override
    public void deleteLog(Integer id) {
        int count = logMapper.deleteLog(id);
        System.out.println(count);
        throw new DefinitionException(StatusEnum.INTERNAL_SERVER_ERROR);
    }
}
