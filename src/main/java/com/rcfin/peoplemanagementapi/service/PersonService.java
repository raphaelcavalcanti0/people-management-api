package com.rcfin.peoplemanagementapi.service;

import com.rcfin.peoplemanagementapi.dto.MessageResponseDTO;
import com.rcfin.peoplemanagementapi.dto.request.PersonDTO;
import com.rcfin.peoplemanagementapi.exception.PersonNotFoundException;
import com.rcfin.peoplemanagementapi.mapper.PersonMapper;
import com.rcfin.peoplemanagementapi.models.Person;
import com.rcfin.peoplemanagementapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople
                .stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deletePerson(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return person;
    }
}