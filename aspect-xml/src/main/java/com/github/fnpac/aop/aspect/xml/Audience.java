package com.github.fnpac.aop.aspect.xml;

import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
public class Audience {

    private static final Logger logger = Logger.getLogger(Audience.class.getName());

    public void silenceCellPhones() {
        logger.info("Silencing cell phones");
    }

    public void takeSeats() {
        logger.info("Taking seats");
    }

    public void applause() {
        logger.info("CLAP CLAP CLAP!!!");
    }

    public void demandRefund() {
        logger.info("Demanding a refund");
    }
}
