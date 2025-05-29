package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@GetMapping()
	public String hello() {
		return "Hello World";
	}

	@PostMapping("/{name}")
	public String hello(@PathVariable("name") String name) {
		System.out.println(name);
		return "Hello " + name;
	}

}
