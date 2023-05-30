package org.shivam;

import java.sql.*;
import java.util.ArrayList;

public class EmiTable {
    private int loanId;
    private int customerId;
    private int typeId;
    private int term;
    private double amount;
    private double interestRate;
    private ArrayList<Double> emis;
    private Connection conn;

    public EmiTable(int id, int cId, int tId, int t, double a, double i) {
        this.loanId = id;
        this.customerId = cId;
        this.typeId = tId;
        this.term = t;
        this.amount = a;
        this.interestRate = i;
        this.emis = new ArrayList<Double>();
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

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public ArrayList<Double> getEmis() {
        return emis;
    }

    public void calculateEmis() {
        double r = interestRate / 1200; // monthly interest rate
        double emi = (amount * r * Math.pow(1 + r, term)) / (Math.pow(1 + r, term) - 1);
        for (int i = 0; i < term; i++) {
            emis.add(emi);
        }
    }

    public void saveEmis() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO emi_table (loan_id, emi_index, emi_amount) VALUES (?, ?, ?)");
        for (int i = 0; i < emis.size(); i++) {
            ps.setInt(1, loanId);
            ps.setInt(2, i+1);
            ps.setDouble(3, emis.get(i));
            ps.executeUpdate();
        }
        ps.close();
    }
}
