package org.app.speed.service;

import org.app.speed.model.bo.LogBO;
import org.app.speed.model.pojo.Log;
import org.app.speed.model.vo.LogVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@SpringBootTest
@Transactional
public class LogServiceTest {

    @Resource
    public LogService logService;


    @Test
    public void insertLog(){
        Log log = new Log();
        log.setMessage("添加信息");
        returnData(logService.insertLog(log));

    }

    @Test
    public void updateLog(){
        Log log = new Log(1,"修改信息");
        returnData(logService.updateLog(log));
    }

    @Test
    public void deleteLog(){
        returnData(logService.deleteLog(1));
    }

    @Test
    public void selectById(){
        logService.selectById(1);
    }

    @Test
    public void selectPagination(){
        LogVO logVO = new LogVO();
        logVO.setOnPage(1);
        logVO.setOnePageSize(10);
        logService.selectPagination(logVO);
    }

    private void returnData(int count){
        if (count == 1){
            Assertions.assertEquals(1,count,"成功");
        }else {
            Assertions.assertEquals(0,count,"失败");
        }
    }




}
