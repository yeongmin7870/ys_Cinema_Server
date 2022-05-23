package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;


@SpringBootApplication
public class TheaterAppApplication  {


	public static void main(String[] args) {
		SpringApplication.run(TheaterAppApplication.class, args);
	}

}
