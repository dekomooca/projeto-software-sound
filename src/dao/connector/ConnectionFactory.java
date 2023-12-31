package dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  public Connection recuperaConexao() {
    try {
      String sgbd = "mysql";
      String endereco = "localhost";
      String bd = "mydb";
      String usuario = "root";
      String senha = "root";

      Connection connection = DriverManager.getConnection(
          "jdbc:" + sgbd + "://" + endereco + "/" + bd + "?useTimezone=true&serverTimezone=UTC", usuario, senha);
      
      return connection;
    } catch (SQLException e) {
      throw new RuntimeException("Erro ao iniciar DB - Verifique sua conexão. ", e);
    }
  }

}