package com.rcfin.peoplemanagementapi.service;

import com.rcfin.peoplemanagementapi.dto.MessageResponseDTO;
import com.rcfin.peoplemanagementapi.dto.request.PersonDTO;
import com.rcfin.peoplemanagementapi.exception.PersonNotFoundException;
import com.rcfin.peoplemanagementapi.mapper.PersonMapper;
import com.rcfin.peoplemanagementapi.models.Person;
import com.rcfin.peoplemanagementapi.repository.PersonRepository;
import com.rcfin.peoplemanagementapi.utils.PersonUtils;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        MessageResponseDTO expectedSuccessMessage = MessageResponseDTO.builder()
                .message("Created person with ID: " + expectedSavedPerson.getIdPerson())
                .build();

        when(personRepository.save(any(Person.class)))
                .thenReturn(expectedSavedPerson);

        MessageResponseDTO successMesssage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMesssage);
    }

    @Test
    void testGivenValidPersonIdThenReturnThisPerson() throws PersonNotFoundException {
        PersonDTO expectedPersonDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        expectedPersonDTO.setIdPerson(expectedSavedPerson.getIdPerson());

        when(personRepository.findById(expectedSavedPerson.getIdPerson()))
                .thenReturn(Optional.of(expectedSavedPerson));

        lenient().when(personMapper.toDTO(expectedSavedPerson)).thenReturn(expectedPersonDTO);

        PersonDTO personDTO = personService.findById(expectedSavedPerson.getIdPerson());

        Assertions.assertEquals(expectedPersonDTO, personDTO);
        Assertions.assertEquals(expectedSavedPerson.getIdPerson(), personDTO.getIdPerson());
        Assertions.assertEquals(expectedSavedPerson.getFirstName(), personDTO.getFirstName());

    }

    @Test
    void testGivenInvalidIdPersonThenThrowException() {
        var invalidPersonId = 1L;
        when(personRepository.findById(invalidPersonId))
                .thenReturn(Optional.ofNullable(any(Person.class)));

        Assertions.assertThrows(PersonNotFoundException.class, () -> personService.findById(invalidPersonId));
    }

    @Test
    void testGivenNoDataThenReturnAllPeopleRegistered() {
        List<Person> expectedRegisteredPeople = Collections.singletonList(PersonUtils.createFakeEntity());
        PersonDTO personDTO = PersonUtils.createFakeDTO();

        personDTO.setIdPerson(1L);

        when(personRepository.findAll()).thenReturn(expectedRegisteredPeople);
        lenient().when(personMapper.toDTO(any(Person.class))).thenReturn(personDTO);

        List<PersonDTO> expectedPersonDTOList = personService.listAll();

        Assertions.assertFalse(expectedPersonDTOList.isEmpty());
        Assertions.assertEquals(expectedPersonDTOList.get(0).getIdPerson(), personDTO.getIdPerson());

    }
}
