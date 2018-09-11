package com.mine.service.database.repository;

import com.mine.service.database.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
