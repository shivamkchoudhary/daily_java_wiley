package org.shivam;

import java.sql.*;

public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "admin123";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Create the account table
            String sql = "CREATE TABLE account " +
                    "(account_number INT NOT NULL PRIMARY KEY, " +
                    "customer_name VARCHAR(255), " +
                    "account_type VARCHAR(255))";
            stmt.executeUpdate(sql);

            // Create the type_of_account table
            sql = "CREATE TABLE type_of_account " +
                    "(type_id INT NOT NULL PRIMARY KEY, " +
                    "type_name VARCHAR(255))";
            stmt.executeUpdate(sql);

            // Create the home_loan table
            sql = "CREATE TABLE home_loan " +
                    "(loan_id INT NOT NULL PRIMARY KEY, " +
                    "customer_id INT, " +
                    "type_id INT, " +
                    "term INT)";
            stmt.executeUpdate(sql);

            // Create the loan_documents table
            sql = "CREATE TABLE loan_documents " +
                    "(loan_id INT NOT NULL, " +
                    "document_index INT NOT NULL, " +
                    "document_data BLOB, " +
                    "PRIMARY KEY (loan_id, document_index))";
            stmt.executeUpdate(sql);

            // Create the loan_application table
            sql = "CREATE TABLE loan_application " +
                    "(loan_id INT NOT NULL PRIMARY KEY, " +
                    "customer_id INT, " +
                    "type_id INT, " +
                    "term INT)";
            stmt.executeUpdate(sql);

            // Create the emi_table table
            sql = "CREATE TABLE emi_table " +
                    "(loan_id INT NOT NULL, " +
                    "emi_index INT NOT NULL, " +
                    "emi_amount DOUBLE, " +
                    "PRIMARY KEY (loan_id, emi_index))";
            stmt.executeUpdate(sql);

            System.out.println("Tables created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
