package com.arkanide.Application.config;

import com.arkanide.Application.model.Student;
import com.arkanide.Application.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                "Mariam",
                "mariam@gmail.com",
                LocalDate.of(2000, 1 , 3)
            );
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2003, 1 , 1)
            );
            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
