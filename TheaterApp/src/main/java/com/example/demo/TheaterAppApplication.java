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

	//https://www.youtube.com/watch?v=CCqVKz6RRLs 을 참조하여 이해가 잘안되지만 알던 구현해보았음 프로젝트를 진행하기에는 부족해보여 더많은 자료를 찾아볼 예정
}
