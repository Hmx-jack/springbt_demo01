package org.hand.springbt_demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@MapperScan("org.hand.springbt_demo01.dao")
public class SpringbtDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbtDemo01Application.class, args);
    }

}
