package com.rubrica.b5r6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rubrica.b5r6.model.PersonDTO;
import com.rubrica.b5r6.repository.PersonRepository;
import com.rubrica.b5r6.service.PersonService;

@RestController
public class PersonRestController {
    
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity<String> persistPerson(@RequestBody PersonDTO person) {
        if(personService.isValid(person)){
            personRepository.persist(person);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
