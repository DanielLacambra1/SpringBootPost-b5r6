package com.rubrica.b5r6.repository;

import org.springframework.stereotype.Repository;

import com.rubrica.b5r6.model.PersonDTO;

@Repository
public class PersonRepositoryImp implements PersonRepository {

    @Override
    public void persist(PersonDTO person) {
        System.out.println("Persisting person: " + person);
        System.out.println(person.getNombre() + " " + person.getApellido() + " " 
        + person.getFnac() + " " + person.getProfesion() + " " + person.getSalario() );
    }
    
}
