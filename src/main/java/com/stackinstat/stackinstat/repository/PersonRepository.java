package com.stackinstat.stackinstat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackinstat.stackinstat.model.Person;

@Transactional
public interface PersonRepository extends Repository<Person, Long> {

    void deleteById(Long personId);

    List<Person> findAllByOrderByLastNameAsc();

    Optional<Person> findById(Long id);

    Person save(Person event);

}
