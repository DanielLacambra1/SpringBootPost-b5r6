package com.rubrica.b5r6;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubrica.b5r6.model.PersonDTO;
import com.rubrica.b5r6.repository.PersonRepository;
import com.rubrica.b5r6.service.PersonService;


@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class PersonRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    
    private JacksonTester<PersonDTO> jsonPersonTester;
    private PersonDTO person;

    @Before
    public void setup(){
        JacksonTester.initFields(this, objectMapper);
        person = new PersonDTO();
    }


    @Test
    public void persitPerson_IsValid_PersonPersisted() throws Exception{
        final String personDTOJson = jsonPersonTester.write(person).getJson();
        given(personService.isValid(any(PersonDTO.class))).willReturn(true);
        mockMvc.perform(post("/persistPerson").content(personDTOJson).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isCreated());
        verify(personRepository).persist(any(PersonDTO.class));
    }

    @Test
    public void persistPerson_IsNotValid_PersonNotPersisted() throws Exception {
        final String personDTOJson = jsonPersonTester.write(person).getJson();
        given(personService.isValid(any(PersonDTO.class))).willReturn(false);
        mockMvc.perform(post("/persistPerson").content(personDTOJson).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isIAmATeapot());
        verify(personRepository, times(0)).persist(any(PersonDTO.class));
    }

}
