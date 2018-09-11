package com.mine.service.person.controller;

import com.mine.service.person.client.PersonDbClient;
import com.mine.service.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 */
@RestController
public class PersonController {

    @Autowired
    private PersonDbClient personDbClient;

    @GetMapping("/person-service")
    public List<Person> getPersons() {
        return personDbClient.getPersons();
    }

    @PostMapping("/person-service")
    public Person createPerson(@RequestBody Person person) {
        return personDbClient.createPerson(person);
    }

    @PutMapping("person-service/{personId}")
    public Person updatePerson(@PathVariable Integer personId, @RequestBody Person person) {
        return personDbClient.updatePerson(personId, person);
    }

    @DeleteMapping("/person-service/{personId}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer personId) {
        return personDbClient.deletePerson(personId);
    }
}
