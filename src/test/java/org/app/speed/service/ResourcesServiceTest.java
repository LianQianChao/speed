package org.app.speed.service;

import org.app.speed.model.pojo.Resources;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ResourcesServiceTest {

    @Resource
    public ResourcesService service;


    @Test
    public void selectAll(){
        List<Resources> resources = service.selectAll();
        resources.forEach(System.out::println);
    }


}
