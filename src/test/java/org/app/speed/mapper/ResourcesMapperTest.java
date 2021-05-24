package org.app.speed.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@Transactional
public class ResourcesMapperTest {

    @Resource
    public ResourcesMapper mapper;

    @Test
    public void selectAll(){
        mapper.selectAll();
    }

}
