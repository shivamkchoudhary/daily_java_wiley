package org.shivam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("==============");
            System.out.println("BANKING OPTIONS");
            System.out.println("==============");
            System.out.println("1. Create account");
            System.out.println("2. Create type of account");
            System.out.println("3. Apply for home loan");
            System.out.println("4. Process loan application");
            System.out.println("5. Calculate EMI payments");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
//                case 2:
//                    createTypeOfAccount();
//                    break;
                case 3:
                    applyForHomeLoan();
                    break;
                case 4:
                    processLoanApplication();
                    break;
                case 5:
                    calculateEmiPayments();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();

        Account account = new Account(accountNumber, customerName, accountType);

        try {
            account.connectDB();
            account.saveToDatabase();
            account.disconnectDB();
            System.out.println("Account created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private static void createTypeOfAccount() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter type ID: ");
//        int typeId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline left-over
//        System.out.print("Enter type name: ");
//        String typeName = scanner.nextLine();
//
//        TypeOfAccount typeOfAccount = new TypeOfAccount(typeId, typeName);
//
//        try {
//            typeOfAccount.connectDB();
//            typeOfAccount.saveToDatabase();
//            typeOfAccount.disconnectDB();
//            System.out.println("Type of account created successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private static void applyForHomeLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter loan ID: ");
        int loanId = scanner.nextInt();
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter type ID: ");
        int typeId = scanner.nextInt();
        System.out.print("Enter term (in months): ");
        int term = scanner.nextInt();

        HomeLoan homeLoan = new HomeLoan(loanId, customerId, typeId, term);

        try {
            homeLoan.connectDB();
            homeLoan.saveToDatabase();
            homeLoan.disconnectDB();
            System.out.println("Home loan application submitted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void processLoanApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter loan ID to process: ");
        int loanId = scanner.nextInt();

        LoanProcess loanProcess = new LoanProcess(loanId, 0, new ArrayList<>());

        try {
            loanProcess.connectDB();
            loanProcess.fetchFromDatabase();

            if (loanProcess.getStatus().equals("PENDING")) {
                byte[] doc1 = Files.readAllBytes(Paths.get("doc1.pdf"));
                byte[] doc2 = Files.readAllBytes(Paths.get("doc2.pdf"));

                loanProcess.setDocuments(new ArrayList<>(Arrays.asList(doc1, doc2)));
                loanProcess.setStatus("APPROVED");
                loanProcess.saveToDatabase();

                System.out.println("Loan application approved.");
            } else {
                System.out.println("Loan application has already been processed.");
            }

            loanProcess.disconnectDB();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateEmiPayments() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter loan ID to calculate EMI payments: ");
        int loanId = scanner.nextInt();

        EmiTable emiTable = new EmiTable(loanId, 0, 0, 0, 0, 0);

        try {
            emiTable.connectDB();
            emiTable.fetchFromDatabase();

            if (emiTable.getLoanAmount() == 0) {
                HomeLoan homeLoan = new HomeLoan(loanId, 0, 0, 0);
                homeLoan.connectDB();
                homeLoan.fetchFromDatabase();
                emiTable.setLoanAmount(homeLoan.getLoanAmount());
                emiTable.setInterestRate(10); // Set interest rate to 10% for now
                homeLoan.disconnectDB();
            }

            emiTable.calculateEmis();
            emiTable.saveEmis();

            System.out.println("EMI payments calculated and saved to database.");

            emiTable.disconnectDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
