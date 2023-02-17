package com.rubrica.b5r6.service;

import org.springframework.stereotype.Service;
import com.rubrica.b5r6.model.PersonDTO;

@Service
public class PersonServiceImp implements PersonService {
    @Override
    public boolean isValid(PersonDTO person) {
        return person != null && person.getProfesion() != null && person.getProfesion().equals("Software Developer");
    }
}
