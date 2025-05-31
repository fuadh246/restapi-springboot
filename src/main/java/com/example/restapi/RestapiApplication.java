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
	public String welcome() {
		return "<h1>Welcome to the REST API!</h1> <br> Please visit <a>http://localhost:8080/api/v1/student</a>";
	}
}
