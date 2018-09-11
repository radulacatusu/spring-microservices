package com.mine.service.person.client;

import com.mine.service.person.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 */
@FeignClient(name = "person-db-service")
public interface PersonDbClient {

    @GetMapping("/persons")
    List<Person> getPersons();

    @PostMapping("/persons")
    Person createPerson(@RequestBody Person person);

    @PutMapping("persons/{personId}")
    Person updatePerson(@PathVariable(value = "personId") Integer personId, @RequestBody Person person);

    @DeleteMapping("/persons/{personId}")
    ResponseEntity<?> deletePerson(@PathVariable(value = "personId") Integer personId);
}