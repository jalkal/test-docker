package com.jalkal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TestDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDockerApplication.class, args);
	}
}

@RestController
class ServiceControler{

	@RequestMapping
	public List<Customer> getAll(){

		return Stream.generate(() -> new Customer(UUID.randomUUID().toString(), getName(), getSurname(), new Random().nextInt(80))).limit(300)
				.collect(Collectors.toList());

	}

	public String getName(){
		String[] names = "Pepe,Juan,Antonio,Lucas,Matias,Luis".split(",");
		return names[new Random().nextInt(names.length)];
	}

	public String getSurname(){
		String[] names = "Douglas,Anderson,Smith,Garcia,Lopez,Perez".split(",");
		return names[new Random().nextInt(names.length)];
	}
}

@Data
@AllArgsConstructor
class Customer{
	String id;

	String name, surname;
	int age;
}
