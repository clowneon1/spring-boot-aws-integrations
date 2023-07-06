package com.clowneon1.aws.springbootdynamodbcrud.serviceImp;

import com.clowneon1.aws.springbootdynamodbcrud.entity.Person;
import com.clowneon1.aws.springbootdynamodbcrud.repository.PersonRepository;
import com.clowneon1.aws.springbootdynamodbcrud.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.find();
    }

    @Override
    public Person getPersonById(String personId) {
        return personRepository.findPersonByPersonId(personId);
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.addPerson(person);
    }

    @Override
    public String updatePerson(Person person) {
        return personRepository.editPerson(person);
    }

    @Override
    public String deletePerson(Person person) {
        return personRepository.deletePerson(person);
    }
}
