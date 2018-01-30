package com.github.fnpac.aop.aspect.business;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
@Component
public class Dancer implements Performance {

    private static final Logger logger = Logger.getLogger(Dancer.class.getName());

    @Override
    public void perform() {
        logger.info("I am dancing");
    }
}
