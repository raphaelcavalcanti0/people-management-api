package com.rcfin.peoplemanagementapi.controllers;

import com.rcfin.peoplemanagementapi.dto.MessageResponseDTO;
import com.rcfin.peoplemanagementapi.models.Person;
import com.rcfin.peoplemanagementapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class ApiController {

    private PersonService personService;

    @Autowired
    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getStarted() {
        return "That's a start!";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
