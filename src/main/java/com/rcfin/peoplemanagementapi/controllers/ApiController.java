package com.rcfin.peoplemanagementapi.controllers;

import com.rcfin.peoplemanagementapi.dto.MessageResponseDTO;
import com.rcfin.peoplemanagementapi.dto.request.PersonDTO;
import com.rcfin.peoplemanagementapi.exception.PersonNotFoundException;
import com.rcfin.peoplemanagementapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class ApiController {

    private PersonService personService;

    @Autowired
    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDTO> getPerson() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) throws PersonNotFoundException {
        personService.deletePerson(id);
    }

}
