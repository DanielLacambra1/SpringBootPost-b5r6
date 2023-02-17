package com.rubrica.b5r6.repository;

import com.rubrica.b5r6.model.PersonDTO;

public interface PersonRepository {
    void persist(PersonDTO person);
}
