package com.bossien.sampleweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bossien")
@EnableJpaRepositories("com.bossien")
@EntityScan("com.bossien")
public class SampleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleWebApplication.class, args);
	}

}
