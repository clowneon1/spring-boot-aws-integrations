package com.clowneon1.aws.springbootdynamodbcrud.service;

import com.clowneon1.aws.springbootdynamodbcrud.entity.Person;

import java.util.List;


public interface PersonService {
    public List<Person> getAllPersons();
    public Person getPersonById(String personId);
    public Person addPerson(Person person);
    public String updatePerson(Person person);
    public String deletePerson(Person person);
 }
