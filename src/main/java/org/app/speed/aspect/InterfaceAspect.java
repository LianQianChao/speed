package org.app.speed.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口权限
 */
@Aspect
@Component
public class InterfaceAspect {

    private long start_time;

    @Pointcut("execution(public * org.app.speed.controller.*.*(..))")
    public void intercept(){

    }

    @Before("intercept()")
    public void before(JoinPoint joinPoint){
        System.out.println("运行前");
        this.start_time = System.currentTimeMillis();
        //获取访问路径
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //请求接口路径
        String url = request.getRequestURI();
        //TODO 权限管理还没做
//        if(url.equals("/test/hello")){
//            System.out.println("访问了/test/hello接口");
//        }else {
//            //自定义异常
//            throw new DefinitionException(StatusEnum.NO_AUTH);
//        }
    }

    @AfterReturning(returning = "object",pointcut = "intercept()")
    public void doAfterReturning(Object object){
        System.out.println("执行成功");
    }

    @AfterThrowing(pointcut = "intercept()")
    public void doAfterThrowing(){
        System.out.println("程序出错");
    }

    @After("intercept()")
    public void doAfter(){
        long end_time = System.currentTimeMillis();

        System.out.println("运行耗时："+(end_time-start_time) +"ms");
    }
}
