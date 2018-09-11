package com.mine.service.database.service;

import com.mine.service.database.model.Person;
import com.mine.service.database.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        person.setUpdatedAt(Calendar.getInstance().getTime());
        person.setCreatedAt(Calendar.getInstance().getTime());
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOne(Integer id) {
        return personRepository.findById(id).get();
    }

    public Person updatePerson(Integer id, Person personRequest) {

        return personRepository.findById(id).map(person -> {

            person.setEmail(personRequest.getEmail());
            person.setFirstName(personRequest.getFirstName());
            person.setLastName(personRequest.getLastName());
            return personRepository.save(person);

        }).orElseThrow(() -> new EntityNotFoundException("Person not found " + id));
    }

    public ResponseEntity<?> deletePerson(Integer personId) {
        return personRepository.findById(personId).map(person -> {
            personRepository.delete(person);
            return ResponseEntity.ok().build();

        }).orElseThrow(() -> new EntityNotFoundException("Person not found " + personId));
    }
}