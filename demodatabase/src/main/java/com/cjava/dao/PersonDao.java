package com.cjava.dao;

import com.cjava.model.Person;

import java.util.List;

//Data Access Object
public interface PersonDao {

  Boolean savePerson(Person person);

  Integer savePersons(List<Person> person);

  List<Person> getAllPersons();
  
  Integer deletePersonsById(Integer id);

  Integer deletePersonsByName(String name);

  Integer updatePersonById(Person updatedPerson, Integer id);
  
}
