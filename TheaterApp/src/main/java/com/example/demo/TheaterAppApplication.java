package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@SpringBootApplication
public class TheaterAppApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(TheaterAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM user1";

		List<Member> memberList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Member.class));

		memberList.forEach(System.out :: println);
	}
}
