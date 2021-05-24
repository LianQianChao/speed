package org.app.speed.aspect;

import org.app.speed.constant.enums.StatusEnum;
import org.app.speed.exception.DefinitionException;
import org.app.speed.model.pojo.Resources;
import org.app.speed.service.ResourcesService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 接口权限
 */
@Aspect
@Component
public class InterfaceAspect {

    @Resource
    private ResourcesService resourcesService;

    private long start_time;

    @Pointcut("execution(public * org.app.speed.controller.*.*(..))")
    public void intercept() {

    }

    @Before("intercept()")
    public void before(JoinPoint joinPoint) {
        System.out.println("运行前");
        this.start_time = System.currentTimeMillis();
        //获取访问路径
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        //请求接口路径
        String url = request.getRequestURI();
        System.out.println(url);
        List<Resources> resources = resourcesService.selectAll();
        System.out.println("sss"+resources.get(0).getMenuUrl());
        for (Resources resource : resources) {
            System.out.println(resource.getMenuUrl());
            if (url.equals(resource.getMenuUrl())) {
                System.out.println("访问了" + resource.getMenuUrl() + "接口");
            } else {
                //自定义异常
                throw new DefinitionException(StatusEnum.NO_AUTH);
            }
        }
//        resources.forEach(resource -> {
//            if (url.equals(resource.getMenuUrl())) {
//                System.out.println("访问了" + resource.getMenuUrl() + "接口");
//            } else {
//                //自定义异常
//                throw new DefinitionException(StatusEnum.NO_AUTH);
//            }
//        });

    }

    @AfterReturning(returning = "object", pointcut = "intercept()")
    public void doAfterReturning(Object object) {
        System.out.println("执行成功");
    }

    @AfterThrowing(pointcut = "intercept()")
    public void doAfterThrowing() {
        System.out.println("程序出错");
    }

    @After("intercept()")
    public void doAfter() {
        long end_time = System.currentTimeMillis();

        System.out.println("运行耗时：" + (end_time - start_time) + "ms");
    }
}
