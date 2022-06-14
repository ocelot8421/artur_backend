package com.artur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories  //>>4.
public class MediMain {

	public static void main(String[] args) {

		SpringApplication.run(MediMain.class, args); //>>4. törlés
	}
}
