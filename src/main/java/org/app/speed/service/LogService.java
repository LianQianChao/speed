package org.app.speed.service;


import org.app.speed.model.bo.LogBO;
import org.app.speed.model.pojo.Log;
import org.app.speed.model.vo.LogVO;
import org.app.speed.utils.PaginationUtil;
public interface LogService {

    int insertLog(Log log);

    int updateLog(Log log);

    int deleteLog(int id);

    Log selectById(int id);

    PaginationUtil<LogBO> selectPagination(LogVO logVO);

}
