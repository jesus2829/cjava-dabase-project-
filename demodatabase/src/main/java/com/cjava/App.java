package com.cjava;

import com.cjava.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "postgres";

        String query = "SELECT * FROM person";
        List<Person> personList = new ArrayList<>();
        try {
          Class.forName("org.postgresql.Driver");
          try(Connection con = DriverManager.getConnection(url, username, password)) {
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
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

        personList.stream()
        .forEach(p -> System.out.println("Person id: " + p.id() + " Person name:" + p.name()));
    }
}
