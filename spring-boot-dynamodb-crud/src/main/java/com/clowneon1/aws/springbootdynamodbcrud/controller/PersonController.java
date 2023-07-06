package com.clowneon1.aws.springbootdynamodbcrud.controller;


import com.clowneon1.aws.springbootdynamodbcrud.entity.Person;
import com.clowneon1.aws.springbootdynamodbcrud.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getALlPersons(){
        return personService.getAllPersons();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String deletePerson(@RequestBody Person person){
        return personService.deletePerson(person);
    }

}
