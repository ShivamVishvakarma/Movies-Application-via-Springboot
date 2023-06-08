package com.moviesApi.MoviesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
//@EntityScan(basePackages = "com.moviesApi.MoviesApp")
public class MoviesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesAppApplication.class, args);
	}

}
