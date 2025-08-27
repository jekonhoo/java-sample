package com.bossien.springcloudbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.bossien")
@RemoteApplicationEventScan("com.bossien")
public class SpringcloudbusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudbusApplication.class, args);
    }

}


