package com.example.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Test2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =SpringApplication.run(Test2Application.class, args);
	}


}
