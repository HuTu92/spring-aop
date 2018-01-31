package com.github.fnpac.aop.aspectj;

import com.github.fnpac.aop.business.CriticismEngine;

import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
public aspect CriticAspect {

    private static final Logger logger = Logger.getLogger(CriticAspect.class.getName());

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

    public CriticAspect() {}

    // aspect是关键字，故包名请避免使用该名称
    // 如果切面不起作用，请将execution改为call
    pointcut performance(): call(* com.github.fnpac.aop.business.Performance.perform(..));

    after() returning : performance(){
        logger.info(criticismEngine.getCriticism());
    }
}
