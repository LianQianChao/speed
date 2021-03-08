package org.app.speed.controller;

import org.app.speed.service.inft.LogService;
import org.app.speed.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日志
 */
@RestController
@RequestMapping(value = "/logs")
public class LogController {

    @Resource
    private LogService logService;
    @GetMapping(value = "/log")
    public ResultUtil selectLog(){

        return ResultUtil.success(logService.selectLog());
    }
}
