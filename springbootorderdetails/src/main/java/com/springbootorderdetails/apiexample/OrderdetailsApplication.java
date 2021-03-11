package com.springbootorderdetails.apiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderdetailsApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderdetailsApplication.class,args);
	}

}
