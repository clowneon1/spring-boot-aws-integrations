package com.clowneon1.aws.springbootdynamodbcrud.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.clowneon1.aws.springbootdynamodbcrud.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private final DynamoDBMapper mapper;

    public Person addPerson(Person person){
        mapper.save(person);
        return person;
    }

    public Person findPersonByPersonId(String personId){
        return mapper.load(Person.class, personId);
    }

    public List<Person> find(){
        return new ArrayList<Person>(mapper.scan(Person.class,new DynamoDBScanExpression()));
    }

    public String deletePerson(Person person){
        mapper.delete(person);
        return "person removed !!";
    }

    public String editPerson(Person person){
        mapper.save(person,buildSaveExpression(person));
        return "Record Updated. ";
    }

    //editing the user
    private DynamoDBSaveExpression buildSaveExpression(Person person){
        //new DynamoDB save expression.
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();

        Map<String , ExpectedAttributeValue> expectedMap = new HashMap<>();

        //creating a map for personId with the new expected values.
        expectedMap.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        dynamoDBSaveExpression.setExpected(expectedMap); //setting expected map.
        return dynamoDBSaveExpression;
    }
}
