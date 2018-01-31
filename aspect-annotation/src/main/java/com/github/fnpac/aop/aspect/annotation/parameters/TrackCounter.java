package com.github.fnpac.aop.aspect.annotation.parameters;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    /**
     * @param trackNum
     */
    @Pointcut(value = "execution(* com.github.fnpac.aop.business.CompactDisc.playTrack(int)) && args(trackNum)")
    public void trackPlayed(int trackNum) {
    }

    @Before("trackPlayed(trackNumber)")
    public synchronized void countTrack(int trackNumber) {
        trackCounts.put(trackNumber, getPlayCount(trackNumber) + 1);
    }

    public synchronized int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}
