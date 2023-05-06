package AdminPackage;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdminService {
    private ArrayList<Product> products;
//    private ArrayList<Customer> customers;
    private String csvFilePath = "products.csv";

    public AdminService() {
        this.products = new ArrayList<Product>();
//        this.customers = new ArrayList<Customer>();

    }



    private void loadProductsFromCsv() {
        try {
            FileReader reader = new FileReader(csvFilePath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
              
                StringTokenizer tokens = new StringTokenizer(line, ",");
                String name = tokens.nextToken();
                double price = Double.parseDouble(tokens.nextToken());
                String description = tokens.nextToken();
                Product p = new Product(name, price, description);
                products.add(p);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error loading products from CSV file!");
        }
    }

    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter product description: ");
        String description = sc.nextLine();

        Product product = new Product(name, price, description);
//        products.add(product);

        try {
            FileWriter writer = new FileWriter(csvFilePath, true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(product.toString());
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error adding product to CSV file!");
        }

        System.out.println("Product added successfully!");
    }

    public void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name to delete: ");
        String name = sc.nextLine();

        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);

                try {
                    FileWriter writer = new FileWriter(csvFilePath);
                    PrintWriter printWriter = new PrintWriter(writer);
                    for (Product p : products) {
                        printWriter.println(p.getName() + "," +
                                p.getPrice() + "," +
                                p.getDecription());
                    }
                    printWriter.close();
                } catch (IOException e) {
                    System.out.println("Error deleting product from CSV file!");
                }

                System.out.println("Product deleted successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    public void viewProducts() {
        products  = new ArrayList<>();
        loadProductsFromCsv();
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void searchProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name to search: ");
        String name = sc.nextLine();
        loadProductsFromCsv();

        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product.toString());
                return;
            }
        }

        System.out.println("Product not found!");
    }
    public Product searchProduct(String name) {

        loadProductsFromCsv();

        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product.toString());
                return product;
            }
        }

        return null;
    }

//    public void addCustomer() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter customer name: ");
//        String name = sc.nextLine();
//        System.out.println("Enter customer email: ");
//        String email = sc.nextLine();
//
//        Customer customer = new Customer(name, email);
//        customers.add(customer);
//        System.out.println("Customer added successfully!");
//    }
//
//    public void removeCustomer() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter customer email to remove: ");
//        String email = sc.nextLine();
//
//        for (Customer customer : customers) {
//            if (customer.getEmail().equals(email)) {
//                customers.remove(customer);
//                System.out.println("Customer removed successfully!");
//                return;
//            }
//        }
//
//        System.out.println("Customer not found!");
//    }

//    public void editCustomerProfile() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter customer email to edit profile: ");
//        String email = sc.nextLine();
//
//        for (Customer customer : customers) {
//            if (customer.getEmail().equals(email)) {
//                System.out.println("Enter new customer name: ");
//                String name = sc.nextLine();
//                System.out.println("Enter new customer email: ");
//                String newEmail = sc.nextLine();
//
//                // check if the new email already exists in the customer list
//                for (Customer c : customers) {
//                    if (c.getEmail().equals(newEmail)) {
//                        System.out.println("Email address already exists!");
//                        return;
//                    }
//                }
//
//                customer.setName(name);
//                customer.setEmail(newEmail);
//
//                System.out.println("Customer profile updated successfully!");
//                return;
//            }
//
//            System.out.println("Customer not found!");
//        }
//    }
//    public void viewCustomers() {
//        System.out.println("\n-- Customers --");
//        if (customers.isEmpty()) {
//            System.out.println("No customers found.");
//        } else {
//            for (Customer c : customers) {
//                System.out.println(c);
//            }
//        }
//    }
//
}
