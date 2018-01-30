package com.github.fnpac.aop.aspectj;

import com.github.fnpac.aop.aspect.business.CriticismEngine;

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

    pointcut performance(): execution(* com.github.fnpac.aop.aspect.business.Performance.perform()(..));

    afterReturning(): performance() {
        logger.info(criticismEngine.getCriticism());
    }
}
