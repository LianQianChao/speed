package org.app.speed.mapper;

import org.app.speed.model.pojo.Log;
import org.app.speed.model.vo.LogVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@Transactional
public class LogMapperTest {

    @Resource
    public LogMapper mapper;

    @Test
    public void insertLog() {
        Log log = new Log();
        log.setMessage("log信息");
        mapper.insertLog(log);

    }

    @Test
    public void updateLog() {
        Log log = new Log();
        log.setId(1);
        log.setMessage("log信息");
        mapper.updateLog(log);
    }

    @Test
    public void deleteLog() {
        mapper.deleteLog(1);
    }

    @Test
    public void selectById() {
        mapper.selectById(1);

    }

    @Test
    public void selectCount() {
        LogVO logVO = new LogVO();
        logVO.setMessage("添加信息");
        int count = mapper.selectCount(logVO);
        System.out.println(count);
    }

    @Test
    public void selectPagination() {
        LogVO logVO = new LogVO();
        logVO.setOnPage(1);
        logVO.setOnePageSize(15);
        mapper.selectPagination(logVO);
    }


}
