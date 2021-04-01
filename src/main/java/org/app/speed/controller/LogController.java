package org.app.speed.controller;

import io.swagger.annotations.Api;
import org.app.speed.model.bo.LogBO;
import org.app.speed.model.pojo.Log;
import org.app.speed.model.vo.LogVO;
import org.app.speed.service.LogService;
import org.app.speed.utils.PaginationUtil;
import org.app.speed.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 日志
 */
@Api(tags = "LogController")
@RestController
@RequestMapping(value = "/system")
public class LogController {

    @Resource
    public LogService logService;

    @Resource
    public ResultUtil<Log> resultUtil;

    @GetMapping(value = "/logs")
    public ResultUtil<PaginationUtil<LogBO>> selectPagination(LogVO logVO) {
        PaginationUtil<LogBO> paginationUtil = logService.selectPagination(logVO);
        return new ResultUtil<PaginationUtil<LogBO>>().success(paginationUtil);
    }

    @PostMapping(value = "/logs")
    public ResultUtil<Log> insertLog(Log log) {
        logService.insertLog(log);
        return resultUtil.success();
    }

    @DeleteMapping("/logs/{id}")
    public ResultUtil<Log> deleteLog(@PathVariable("id") int id) {
        logService.deleteLog(id);
        return resultUtil.success();
    }

    @GetMapping(value = "/logs/{id}")
    public ResultUtil<Log> selectById(@PathVariable("id") int id) {
        return resultUtil.success(logService.selectById(id));
    }

    @PutMapping(value = "/logs/{id}")
    public ResultUtil<Log> updateLog(@PathVariable("id") int id, Log log) {
        log.setId(id);
        logService.updateLog(log);
        return resultUtil.success();
    }

}
