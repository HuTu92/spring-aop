package com.github.fnpac.aop.aspect.business;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
@Component
public class BlankDisc implements CompactDisc {

    private static final Logger logger = Logger.getLogger(BlankDisc.class.getName());

    private String title;
    private String artist;
    private List<String> tracks;

    @Override
    public void playTrack(int trackNumber) {
        logger.info(tracks.get(trackNumber));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
