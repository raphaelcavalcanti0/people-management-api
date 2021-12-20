package com.rcfin.peoplemanagementapi.service;

import com.rcfin.peoplemanagementapi.dto.MessageResponseDTO;
import com.rcfin.peoplemanagementapi.dto.request.PersonDTO;
import com.rcfin.peoplemanagementapi.mapper.PersonMapper;
import com.rcfin.peoplemanagementapi.models.Person;
import com.rcfin.peoplemanagementapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getIdPerson())
                .build();
    }
}
