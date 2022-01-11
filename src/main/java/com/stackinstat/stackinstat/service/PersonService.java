package com.stackinstat.stackinstat.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackinstat.stackinstat.model.Person;
import com.stackinstat.stackinstat.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {

        List<Person> person = personRepository.findAllByOrderByLastNameAsc();

        person.stream().forEach(p -> {
            p.setAge(Period.between(p.getBirthDate(), LocalDate.now()).getYears());
        });

        return person;
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public Person create(Person person) throws Exception {

        if (person.getBirthDate() == null
                || java.time.temporal.ChronoUnit.YEARS.between(person.getBirthDate(), LocalDate.now()) > 150) {
            throw new Exception("more than 150 years!");
        }

        return personRepository.save(person);
    }

}
