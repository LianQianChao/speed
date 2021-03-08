package org.app.speed.service.impl;

import org.app.speed.mapper.LogMapper;
import org.app.speed.model.pojo.Log;
import org.app.speed.service.inft.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
     private LogMapper logMapper;


    @Override
    public List<Log> selectLog() {
        return logMapper.selectLog();
    }
}
