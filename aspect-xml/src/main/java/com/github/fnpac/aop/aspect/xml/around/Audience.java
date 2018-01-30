package com.github.fnpac.aop.aspect.xml.around;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
public class Audience {

    private static final Logger logger = Logger.getLogger(Audience.class.getName());

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
