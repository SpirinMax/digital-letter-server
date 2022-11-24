package org.kngmuseum.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "org.kngmuseum.controllers", "org.kngmuseum.service" })
@EntityScan(basePackages = "org.kngmuseum.dataObjects")
@EnableJpaRepositories(basePackages = "org.kngmuseum.dataCrudInterfaces")
@SpringBootApplication
public class DigitalLetterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalLetterApplication.class, args);
	}

}
