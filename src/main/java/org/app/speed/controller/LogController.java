package org.app.speed.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.app.speed.service.inft.LogService;
import org.app.speed.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日志
 */
@Api(tags = "LogController")
@RestController
@RequestMapping(value = "/logs")
public class LogController {

    @Resource
    private LogService logService;
    @GetMapping(value = "/log")
    public ResultUtil selectLog(){

        return ResultUtil.success(logService.selectLog());
    }

    @GetMapping(value = "/log/{id}")
    public ResultUtil selectLogById(@PathVariable("id") Integer id){
        logService.deleteLog(id);
        return ResultUtil.success();
//        return ResultUtil.success(logService.selectLogById(id));
    }


}
