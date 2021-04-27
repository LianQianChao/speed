package org.app.speed.service.impl;

import org.app.speed.constant.enums.StatusEnum;
import org.app.speed.exception.DefinitionException;
import org.app.speed.mapper.LogMapper;
import org.app.speed.model.bo.LogBO;
import org.app.speed.model.pojo.Log;
import org.app.speed.model.vo.LogVO;
import org.app.speed.service.LogService;
import org.app.speed.utils.PaginationUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试Redis
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    public LogMapper logMapper;


    @Override
    public int insertLog(Log log) {
        return returnData(logMapper.insertLog(log));
    }

    @Override
    public int updateLog(Log log) {
        return returnData(logMapper.updateLog(log));
    }

    @Override
    public int deleteLog(int id) {
        return returnData(logMapper.deleteLog(id));
    }

    @Override
    public Log selectById(int id) {
        return logMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param logVO 查询条件
     * @return 分页数据
     */
    @Override 
    public PaginationUtil<LogBO> selectPagination(LogVO logVO) {
        return new PaginationUtil<>(logVO.getOnPage(), logVO.getOnePageSize(),
                logMapper.selectCount(logVO), logMapper.selectPagination(logVO));
    }

    private int returnData(int count) {
        if (count == 1) {
            return count;
        }
        throw new DefinitionException(StatusEnum.INTERNAL_SERVER_ERROR);
    }
}
