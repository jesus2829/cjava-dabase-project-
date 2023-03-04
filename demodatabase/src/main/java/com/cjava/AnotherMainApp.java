package com.cjava;

import com.cjava.dao.PersonDao;
import com.cjava.dao.PersonDaoImpl;
import com.cjava.model.Person;

import java.util.List;

public class AnotherMainApp {

  public static void main(String[] args) {
    PersonDao personDao = new PersonDaoImpl();

    Person newPerson = new Person(5,"Edward");

    Boolean result = personDao.savePerson(newPerson);

    System.out.println(result);
    
    List<Person> persons = personDao.getAllPersons();

    persons.forEach(p -> System.out.println("Person id: " + p.id() + " Person name:" + p.name()));


  }
  
}
