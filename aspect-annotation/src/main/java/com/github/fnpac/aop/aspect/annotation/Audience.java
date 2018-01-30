package com.github.fnpac.aop.aspect.annotation;

import org.aspectj.lang.annotation.*;

import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
// 这里只是使用了AspectJ的注解（起标记作用），实际还是基于spring的动态代理实现
// 千万别忘了注册为spring bean
@Aspect
public class Audience {

    private static final Logger logger = Logger.getLogger(Audience.class.getName());

    /**
     * 切点
     */
    @Pointcut(value = "execution(* com.github.fnpac.aop.aspect.business.Performance.perform(..))")
    public void performance() {
    }

//    @Before(value = "execution(* com.github.fnpac.aop.aspect.business.Performance.perform(..))") // 这种方式出现了切点的重复指定
    @Before(value = "performance()")
    public void silenceCellPhones() {
        logger.info("Silencing cell phones");
    }

    //    @Before("execution(* com.github.fnpac.aop.aspect.business.Performance.perform(..))")
    @Before(value = "performance()")
    public void takeSeats() {
        logger.info("Taking seats");
    }

    //    @AfterReturning("execution(* com.github.fnpac.aop.aspect.business.Performance.perform(..))")
    @AfterReturning(value = "performance()")
    public void applause() {
        logger.info("CLAP CLAP CLAP!!!");
    }

    //    @AfterThrowing("execution(* com.github.fnpac.aop.aspect.business.Performance.perform(..))")
    @AfterThrowing(value = "performance()")
    public void demandRefund() {
        logger.info("Demanding a refund");
    }
}
