package com.github.fnpac.aop.aspect;

import com.github.fnpac.aop.aspect.business.CompactDisc;
import com.github.fnpac.aop.aspect.business.Encoreable;
import com.github.fnpac.aop.aspect.business.Performance;
import com.github.fnpac.aop.aspect.xml.parameters.TrackCounter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.Assert;

@SpringBootApplication
@ComponentScan("com.github.fnpac")
public class XmlAopApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(XmlAopApplication.class, args);

//        perform();
//        playTrack();
        performEncore();
    }

    /**
     * 在Spring中， 切面只是实现了它们所包装bean相同接口的代理。
     * <p>
     * 所以这里只能通过Performance.class 和 "dancer" 去获取 Dancer类的代理
     *
     */
    private static void perform() {
        Performance performance = context.getBean("dancer", Performance.class);
        performance.perform();
    }

    private static void playTrack() {
        CompactDisc cd = context.getBean("blankDisc", CompactDisc.class);
        TrackCounter counter = context.getBean("parametersAspect", TrackCounter.class);

        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);

        Assert.isTrue(1 == counter.getPlayCount(1));
        Assert.isTrue(1 == counter.getPlayCount(2));
        Assert.isTrue(4 == counter.getPlayCount(3));
        Assert.isTrue(0 == counter.getPlayCount(4));
        Assert.isTrue(0 == counter.getPlayCount(5));
    }

    private static void performEncore() {
        Encoreable encoreable = context.getBean("dancer", Encoreable.class);
        encoreable.performEncore();
    }
}
