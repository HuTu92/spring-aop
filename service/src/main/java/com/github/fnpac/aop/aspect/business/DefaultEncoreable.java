package com.github.fnpac.aop.aspect.business;

import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
public class DefaultEncoreable implements Encoreable {

    private static final Logger logger = Logger.getLogger(DefaultEncoreable.class.getName());

    @Override
    public void performEncore() {
        logger.info("perform Encore");
    }
}
