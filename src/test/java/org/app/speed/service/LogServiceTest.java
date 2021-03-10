package org.app.speed.service;

import lombok.extern.slf4j.Slf4j;
import org.app.speed.service.inft.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest()
@RunWith(SpringRunner.class)
public class LogServiceTest {

    @Resource
    private LogService logService;

    @Test
    public void deleteLog(){

        logService.deleteLog(1);


    }
}
