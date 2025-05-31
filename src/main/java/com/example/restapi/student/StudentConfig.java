package com.example.restapi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Fuad = new Student(
                    "Fuad",
                    "fuad@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5)
            );
            Student Hassan = new Student(
                    "Hassan",
                    "Hassan@gmail.com",
                    LocalDate.of(1999,Month.FEBRUARY,5)
            );
            repository.saveAll(List.of(Fuad,Hassan));
        };
    };
}
