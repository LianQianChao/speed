package org.app.speed.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(public * org.app.speed.controller.*.*(..))")
    public void intercept(){

    }

    @Before("intercept()")
    public void before(JoinPoint joinPoint){
        System.out.println("运行前");
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

        System.out.println("运行后");
    }
}
