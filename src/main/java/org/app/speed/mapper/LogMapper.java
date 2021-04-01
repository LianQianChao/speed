package org.app.speed.mapper;

import org.app.speed.model.bo.LogBO;
import org.app.speed.model.pojo.Log;
import org.app.speed.model.vo.LogVO;

import java.util.List;

public interface LogMapper {


    int insertLog(Log log);

    int deleteLog(int id);

    int updateLog(Log log);

    int selectCount(LogVO logVO);

    Log selectById(int id);


    List<LogBO> selectPagination(LogVO logVO);
}
