package org.shivam;

import java.sql.*;

public class Account {
    private int accountId;
    private String customerName;
    private String accountType;
    private Connection conn;

    public Account(int id, String name, String type) {
        this.accountId = id;
        this.customerName = name;
        this.accountType = type;
    }

    public void connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "admin123";
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public void disconnectDB() throws SQLException {
        this.conn.close();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}

