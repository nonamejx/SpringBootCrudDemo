package com.noname.interest.SpringBootCrudDemo;

import com.noname.interest.SpringBootCrudDemo.model.User;
import com.noname.interest.SpringBootCrudDemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCrudDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootCrudDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			for (User u : repository.findAll()) {
				log.error(u.toString());
			}
		};
	}
}
