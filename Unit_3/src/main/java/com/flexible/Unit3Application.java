package com.flexible;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-12-05
 * Time: 15:34
 */
@SpringBootApplication
@EntityScan("com.flexible.entity")
@EnableJpaRepositories("com.flexible.jpa")
public class Unit3Application {
    public static void main(String[] args) {
//        ImprovedNamingStrategy
        SpringApplication.run(Unit3Application.class,args);
    }
}
