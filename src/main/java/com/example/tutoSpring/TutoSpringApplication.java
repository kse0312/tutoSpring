package com.example.tutoSpring;

import com.example.tutoSpring.models.Customer;
import com.example.tutoSpring.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutoSpringApplication {
	private static final Logger log = LoggerFactory.getLogger(TutoSpringApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TutoSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(CustomerRepository repository){
		return args -> {
			repository.save(new Customer("leo", "le"));

			for(Customer customer : repository.findAll()){
				log.info(customer.toString());
			}
			log.info("");
		};
	}
}
