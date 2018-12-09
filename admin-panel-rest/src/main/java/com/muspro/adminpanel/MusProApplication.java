package com.muspro.adminpanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MusProApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusProApplication.class, args);
	}
}
