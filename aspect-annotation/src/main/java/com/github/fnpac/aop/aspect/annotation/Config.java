package com.github.fnpac.aop.aspect.annotation;

import com.github.fnpac.aop.aspect.annotation.introductions.EncoreableIntroducer;
import com.github.fnpac.aop.aspect.annotation.parameters.TrackCounter;
import com.github.fnpac.aop.business.BlankDisc;
import com.github.fnpac.aop.business.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘春龙 on 2018/1/30.
 */
@Configuration
@EnableAspectJAutoProxy // 启用自动代理功能
public class Config {

    ////////////////////////////////////////////////////////////////////
    //                  切面：定义切面
    ////////////////////////////////////////////////////////////////////

    //    @Bean
    public Audience simpleAspect() {
        return new Audience();
    }

    ////////////////////////////////////////////////////////////////////
    //                  切面：创建环绕通知
    ////////////////////////////////////////////////////////////////////

    //    @Bean
    public com.github.fnpac.aop.aspect.annotation.around.Audience aroundAspect() {
        return new com.github.fnpac.aop.aspect.annotation.around.Audience();
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

    ////////////////////////////////////////////////////////////////////
    //                  切面：通过注解引入新功能
    ////////////////////////////////////////////////////////////////////
    @Bean
    public EncoreableIntroducer introducer() {
        return new EncoreableIntroducer();
    }
}
