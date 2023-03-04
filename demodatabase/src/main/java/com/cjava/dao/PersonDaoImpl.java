package com.cjava.dao;

import com.cjava.dao.connection.ConnectionUtils;
import com.cjava.model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

  private ConnectionUtils connectionUtils;
  private String url = "jdbc:postgresql://localhost:5432/postgres";
  private String username = "postgres";
  private String password = "postgres";


  public PersonDaoImpl() {
    connectionUtils = ConnectionUtils.getInstance(url,username,password);
  }

  @Override
  public Boolean savePerson(Person person) {
    try(Connection con = connectionUtils.getConnection()) {
      Statement stmt = con.createStatement();
      String sqlQuery = "INSERT INTO PERSON VALUES (" + person.id() + ", '" + person.name() + "');";
      if(stmt.executeUpdate(sqlQuery) > 0) {
        return true;
      } else {
        return false;
      }
    } catch(Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public Integer savePersons(List<Person> person) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'savePersons'");
  }

  @Override
  public List<Person> getAllPersons() {
    String query = "SELECT * FROM person";
    List<Person> personList = new ArrayList<>();
    try(Connection con = connectionUtils.getConnection()) {
      Statement stmt = con.createStatement();
      ResultSet resultSet = stmt.executeQuery(query);
      System.out.println( "connection successfully" );
      while(resultSet.next()) {
        String id = resultSet.getString("id");
        Integer idInteger = Integer.valueOf(id);
        String name = resultSet.getString("name");
        Person person = new Person(idInteger, name);
        personList.add(person);
      }
      
    } catch(Exception e) {
      e.printStackTrace();
    }

    return personList;
  }

  @Override
  public Integer deletePersonsById(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deletePersonsById'");
  }

  @Override
  public Integer deletePersonsByName(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deletePersonsByName'");
  }

  @Override
  public Integer updatePersonById(Person updatedPerson, Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updatePersonById'");
  }
  
}
