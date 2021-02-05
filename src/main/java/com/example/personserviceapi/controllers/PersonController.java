package com.example.personserviceapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.lundogbendsen.springbootcourse.api.personservice.model.Person;
import dk.lundogbendsen.springbootcourse.api.personservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping
    public List<Person> list() {
        return personService.list();
    }

    @PostMapping
    public Person create(@RequestParam String name, @RequestParam Long age) {
        Person person = Person.builder().name(name).age(age).build();
        personService.create(person);
        return person;
    }

    @PutMapping("{id}")
    public Person update(@PathVariable Long id, @RequestBody Map<String, String> personMap) {
        Person person = Person.builder()
                .id(id)
                .name(personMap.get("name"))
                .age(Long.parseLong(personMap.get("age")))
                .build();
        return personService.update(person);
    }

    @GetMapping("{id}")
    public Person get(@PathVariable Long id) {
        return personService.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}
