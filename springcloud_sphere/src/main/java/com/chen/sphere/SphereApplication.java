package com.chen.sphere;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
@MapperScan("com.chen.sphere.mapper")
public class SphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(SphereApplication.class, args);
	}
}