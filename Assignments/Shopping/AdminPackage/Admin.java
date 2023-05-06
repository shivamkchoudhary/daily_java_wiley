package AdminPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin {
    private AdminService adminService;

    public Admin() {
        this.adminService = new AdminService();
    }

    public void productsPage() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\n*** Products Page ***");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. View products");
            System.out.println("4. Search product");
            System.out.println("5. Back to main menu");

            try {
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        adminService.addProduct();
                        break;
                    case 2:
                        adminService.deleteProduct();
                        break;
                    case 3:
                        adminService.viewProducts();
                        break;
                    case 4:
                        adminService.searchProduct();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format! Please enter a number.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void customersPage() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        while (true) {
//            System.out.println("\n*** Customers Page ***");
//            System.out.println("1. Add customer");
//            System.out.println("2. Remove customer");
//            System.out.println("3. Edit customer profile");
//            System.out.println("4. View registered customers");
//            System.out.println("5. Back to main menu");

//            try {
//                int choice = Integer.parseInt(br.readLine());
//
//                switch (choice) {
//                    case 1:
//                        adminService.addCustomer();
//                        break;
//                    case 2:
//                        adminService.removeCustomer();
//                        break;
//                    case 3:
//                        adminService.editCustomerProfile();
//                        break;
//                    case 4:
//                        adminService.viewCustomers();
//                        break;
//                    case 5:
//                        return;
//                    default:
//                        System.out.println("Invalid choice!");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input format! Please enter a number.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void mainMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("*** Main Menu ***");
            System.out.println("1. Products");
//            System.out.println("2. Customers");
            System.out.println("2. Exit");

            try {
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        productsPage();
                        break;
//                    case 2:
//                        customersPage();
//                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format! Please enter a number.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}