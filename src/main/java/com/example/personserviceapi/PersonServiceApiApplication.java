package com.example.personserviceapi;

import dk.lundogbendsen.springbootcourse.api.personservice.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApiApplication.class, args);
    }

    @Bean
    public PersonService personService() {
        return new PersonService();
    }
}
