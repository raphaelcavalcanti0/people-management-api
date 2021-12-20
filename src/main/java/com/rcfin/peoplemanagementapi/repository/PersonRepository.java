package com.rcfin.peoplemanagementapi.repository;

import com.rcfin.peoplemanagementapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
