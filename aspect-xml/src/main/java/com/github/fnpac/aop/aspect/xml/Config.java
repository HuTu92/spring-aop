package com.github.fnpac.aop.aspect.xml;

import com.github.fnpac.aop.aspect.business.BlankDisc;
import com.github.fnpac.aop.aspect.business.CompactDisc;
import com.github.fnpac.aop.aspect.xml.parameters.TrackCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
@Configuration
@ImportResource("classpath:spring-ctx.xml")
public class Config {

    ////////////////////////////////////////////////////////////////////
    //                  切面：定义切面
    ////////////////////////////////////////////////////////////////////
    @Bean
    public Audience simpleAspect() {
        return new Audience();
    }

    ////////////////////////////////////////////////////////////////////
    //                  切面：创建环绕通知
    ////////////////////////////////////////////////////////////////////
    @Bean
    public com.github.fnpac.aop.aspect.xml.around.Audience aroundAspect() {
        return new com.github.fnpac.aop.aspect.xml.around.Audience();
    }

    ////////////////////////////////////////////////////////////////////
    //                  切面：处理通知中的参数
    ////////////////////////////////////////////////////////////////////
    @Bean
    public TrackCounter parametersAspect() {
        return new TrackCounter();
    }

    @Bean
    public CompactDisc blankDisc() {
        BlankDisc cd = new BlankDisc();

        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");

        List<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");
        // ...other tracks omitted for brevity...
        cd.setTracks(tracks);

        return cd;
    }
}
