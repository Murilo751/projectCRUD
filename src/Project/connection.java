package Project;

import java.sql.*;

public class connection {
    private Connection conn;

    public Connection connect_to_db(String dbname, String user, String password) {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password);
            if (conn != null) {
                System.out.println("Conexão estabeleciada");
            } else {
                System.out.println("Falha na conexão");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conn;

    }

    public Connection getConnection() {
        return this.conn;
    }

}
