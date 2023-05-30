package org.shivam;

import java.sql.*;

public class HomeLoan {
    private int loanId;
    private int customerId;
    private int typeId;
    private int term;
    private Connection conn;

    public HomeLoan(int id, int cId, int tId, int t) {
        this.loanId = id;
        this.customerId = cId;
        this.typeId = tId;
        this.term = t;
    }

    public void connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "password";
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
}
