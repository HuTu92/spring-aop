package com.github.fnpac.aop.aspect.xml.parameters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    public synchronized void countTrack(int trackNumber) {
        trackCounts.put(trackNumber, getPlayCount(trackNumber) + 1);
    }

    public synchronized int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}
