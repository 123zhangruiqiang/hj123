package com.zhangruiqiang.hj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zhangruiqiang.mapper")
@ComponentScan(basePackages = {"com.zhangruiqiang.controller","com.zhangruiqiang.service"})
@EnableScheduling
public class HjApplication {

	public static void main(String[] args) {
		SpringApplication.run(HjApplication.class, args);
	}
}
