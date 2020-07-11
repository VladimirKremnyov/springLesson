package org.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksRepository {

    private static final String url = "jdbc:mysql://localhost:3306/jdbc_lesson";
    private static final String user = "root";
    private static final String password = "qwerty2020";

    public List<BookEntity> findAll() {
        List<BookEntity> books = new ArrayList<>();
        String query = "INSERT INTO books (id, name, author) VALUES (7, \"qwerty1\", \"some author\")";
        String query2 = "INSERT INTO books (id, name, author) VALUES (8, \"qwerty2\", \"some author\")";
        String selectQuery = "SELECT * FROM books";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connection();
            statement = connection.createStatement();
            connection.setAutoCommit(false);
            statement.addBatch(query);
            statement.addBatch(query2);
            int[] ints = statement.executeBatch();
//            ResultSet resultSet = statement.executeQuery(selectQuery);
//            while (resultSet.next()) {
//                long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String author = resultSet.getString("author");
//                books.add(new BookEntity(id, name, author));
//            }
            connection.commit();
            return books;
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new DatabaseException(e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
