package org.shivam;

import java.sql.*;
import java.util.ArrayList;
import java.io.*;

public class LoanProcess {
    private int loanId;
    private int customerId;
    private ArrayList<byte[]> documents;
    private Connection conn;

    public LoanProcess(int id, int cId, ArrayList<byte[]> docs) {
        this.loanId = id;
        this.customerId = cId;
        this.documents = docs;
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

    public ArrayList<byte[]> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<byte[]> documents) {
        this.documents = documents;
    }

    public void uploadDocument(int docIndex, byte[] data) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO loan_documents (loan_id, document_index, document_data) VALUES (?, ?, ?)");
        ps.setInt(1, loanId);
        ps.setInt(2, docIndex);
        ps.setBytes(3, data);
        ps.executeUpdate();
        ps.close();
    }

    public byte[] downloadDocument(int docIndex) throws SQLException, IOException {
        PreparedStatement ps = conn.prepareStatement("SELECT document_data FROM loan_documents WHERE loan_id = ? AND document_index = ?");
        ps.setInt(1, loanId);
        ps.setInt(2, docIndex);
        ResultSet rs = ps.executeQuery();
        byte[] data = null;
        if (rs.next()) {
            Blob blob = rs.getBlob("document_data");
            data = blob.getBytes(1, (int)blob.length());
        }
        rs.close();
        ps.close();
        return data;
    }
}
