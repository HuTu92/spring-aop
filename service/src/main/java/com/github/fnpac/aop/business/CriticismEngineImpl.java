package com.github.fnpac.aop.business;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
public class CriticismEngineImpl implements CriticismEngine {

    private String[] criticismPool;

    @Override
    public String getCriticism() {
        int index = (int) (Math.random() * criticismPool.length);
        return criticismPool[index];
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
