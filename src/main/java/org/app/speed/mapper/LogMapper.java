package org.app.speed.mapper;

import org.app.speed.model.pojo.Log;

import java.util.List;

public interface LogMapper {

    List<Log> selectLog();

    Log selectLogById(Integer id);
}
