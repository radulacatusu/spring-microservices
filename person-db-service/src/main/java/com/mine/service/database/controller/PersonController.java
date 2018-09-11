package com.mine.service.database.controller;

import com.mine.service.database.model.Person;
import com.mine.service.database.service.PersonService;
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
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPerson() {
        return personService.findAll();
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("persons/{personId}")
    public Person updatePerson(@PathVariable Integer personId, @RequestBody Person person) {
        return personService.updatePerson(personId, person);
    }

    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer personId) {
        return personService.deletePerson(personId);
    }

}