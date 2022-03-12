package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TheaterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheaterAppApplication.class, args);
	}

	@GetMapping
	public String helloWorld(){
		return "I wanna go Mars";
	}
}
