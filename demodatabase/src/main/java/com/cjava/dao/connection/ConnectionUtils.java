package com.cjava.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
  
  private static ConnectionUtils INSTANCE;
  private static Connection CON;
  private final String url;
  private final String user;
  private final String password;

  private ConnectionUtils(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public static ConnectionUtils getInstance(String url, String user, String password) {
    if(INSTANCE == null) {
      INSTANCE = new ConnectionUtils(url, user, password);
    }
    return INSTANCE;
  }


  public Connection getConnection() throws SQLException, ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
    if(CON != null && !CON.isClosed()) {
      return CON;
    } else {
      CON = DriverManager.getConnection(url, user, password);
      return CON;
    }
  }
}
