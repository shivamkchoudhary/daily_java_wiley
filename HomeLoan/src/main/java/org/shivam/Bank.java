package org.shivam;

import java.sql.*;
public class Bank {
    private int bankId;
    private String bankName;
    private String bankAddress;
    private Connection conn;

    public Bank(int id, String name, String address) {
        this.bankId = id;
        this.bankName = name;
        this.bankAddress = address;
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

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }
}
