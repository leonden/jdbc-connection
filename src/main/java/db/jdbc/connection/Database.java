package db.jdbc.connection;

import java.sql.*;

public class Database {
    public static void main(String[] args) {

        String url = /* "jdbc:mysql://localhost:3306/MY_DATA_BASE" */;
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connection succsessful");

            // insert
//            String query = "INSERT INTO MY_TABLE (col1, col2, col3) VALUES (value1, value2, value3)"; // sql statement
//            Statement statement = conn.createStatement();
//            statement.execute();

            // ---------------------------------------------------------------------------------------------------------

            // output
            String query = /* "SELECT * FROM MY_TABLE" */; // sql statement
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int columns = resultSet.getMetaData().getColumnCount();

            for (int i = 1; i <= columns; i++)
                System.out.print(String.format("%-15s", resultSet.getMetaData().getColumnLabel(i)));
            System.out.println();
            System.out.println("--------------------------------------------------------");

            while (resultSet.next()) {

                for (int i = 1; i <= columns; i++)
                    System.out.println(String.format("%-15s", resultSet.getString(i)));

            }

            resultSet.close();
            statement.close();

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());

        }
    }
}

