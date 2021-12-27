package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

@Service
public class SignUp {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public List<User> SignUp() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "INSERT INTO user (Uid, Name, Password) VALUE (uid, name, password)";

      return connection.createQuery(query).executeAndFetch(User.class);
    }
  }
}
