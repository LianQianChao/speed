package org.app.speed.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.app.speed.model.pojo.Log;

import java.util.List;

@Mapper
public interface LogMapper {

    List<Log> selectLog();
}
