package com.github.fnpac.aop.aspectj;

import com.github.fnpac.aop.business.Performance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("com.github.fnpac")
@ImportResource("classpath:spring-ctx.xml")
public class AspectJAopApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(AspectJAopApplication.class, args);

        perform();
    }

    private static void perform() {
        Performance performance = context.getBean("dancer", Performance.class);
        performance.perform();
    }
}
