package com.github.fnpac.aop.aspect.annotation.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
@Aspect // 千万别忘了注册为spring bean
public class Audience {

    private static final Logger logger = Logger.getLogger(Audience.class.getName());

    /**
     * 切点
     */
    @Pointcut(value = "execution(* com.github.fnpac.aop.business.Performance.perform(..))")
    public void performance() {
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            logger.info("Silencing cell phones...");
            logger.info("Taking seats...");

            joinPoint.proceed();

            logger.info("CLAP CLAP CLAP!!!...");
        } catch (Throwable e) {
            logger.info("Demanding a refund...");
        }
    }
}
