package com.stackinstat.stackinstat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackinstat.stackinstat.model.Person;
import com.stackinstat.stackinstat.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(person));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPersons() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(personService.getPersons());
    }

}
