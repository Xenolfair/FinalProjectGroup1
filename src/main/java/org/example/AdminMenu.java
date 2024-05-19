package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AdminMenu {
    public static void showMenuAdmin( User user, Scanner scanner) {
        boolean leave = false;

        while (!leave) {
            System.out.println("\n--> Options: ");
            System.out.println("          1. Product management");
            System.out.println("          2. Generate Inventory Report");
            System.out.println("          3. Generate Sales Report");
            System.out.println("          4. Manage user roles");
            System.out.println("          5. Sales Management");
            System.out.println("          6. Provider Management");
            System.out.println("          9. exit");
            System.out.print("\n --> Choose an option: ");

            int userElection = scanner.nextInt();
            switch(userElection){
                case 1:
                    productManagementMenu();
                    break;
                case 2:
                    Report.generateInventoryReport();
                    break;
                case 3:
                    Report.generateSalesReport();
                    break;
                case 4:
                    User.manageUsers(scanner);
                    break;
                case 5:
                    Sale.manageSales(scanner, Sale.salesList);
                    break;
                case 6:
                    Provider.manageProviders(scanner);
                    break;
                case 9:
                    System.out.println("See you soon...");
                    leave = true;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option");
                    break;
            }
        }
    }

    public static void productManagementMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Product Management system!");
        System.out.println("\n--> Options: ");
        System.out.println("          1. Add new product");
        System.out.println("          2. Modify an existing product");
        System.out.println("          3. Delete an existing product");
        System.out.println("          4. back");
        System.out.print("\n --> Choose an option: ");

        int userElection2 = scanner.nextInt();
        switch(userElection2) {
            case 1:
                System.out.print("Enter product ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter product name: ");
                String name = scanner.nextLine();

                System.out.print("Enter product description: ");
                String description = scanner.nextLine();

                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();

                System.out.print("Enter stock quantity: ");
                int stockQuantity = scanner.nextInt();
                scanner.nextLine();

                Product product = new Product(id, name, description, price, stockQuantity);
                Product.productList.add(product);
                System.out.println("  Product added successfully!");

                break;
            case 2:
                System.out.println("--> Search product by:");
                System.out.println("          1. ID");
                System.out.println("          2. Name");
                System.out.print("\n --> Choose an option: ");

                int searchOption = scanner.nextInt();
                scanner.nextLine();

                Product productToModify = null;
                if (searchOption == 1) {
                    System.out.print("Enter product ID to modify: ");
                    int modifyId = scanner.nextInt();
                    scanner.nextLine();

                    productToModify = Product.findProductById(modifyId);
                } else if (searchOption == 2) {
                    System.out.print("Enter product name to modify: ");
                    String modifyName = scanner.nextLine();

                    productToModify = Product.findProductByName(modifyName);
                } else {
                    System.out.println("Invalid option. Please choose again.");
                    break;
                }

                if (productToModify != null) {
                    System.out.print("Enter new product name (leave blank to keep current): ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        productToModify.setName(newName);
                    }

                    System.out.print("Enter new product description (leave blank to keep current): ");
                    String newDescription = scanner.nextLine();
                    if (!newDescription.isEmpty()) {
                        productToModify.setDescription(newDescription);
                    }

                    System.out.print("Enter new product price (or 0 to keep current): ");
                    double newPrice = scanner.nextDouble();
                    if (newPrice != 0) {
                        productToModify.setPrice(newPrice);
                    }

                    System.out.print("Enter new stock quantity (or -1 to keep current): ");
                    int newStockQuantity = scanner.nextInt();
                    scanner.nextLine();
                    if (newStockQuantity != -1) {
                        productToModify.setStockQuantity(newStockQuantity);
                    }

                    System.out.println("Product modified successfully!");
                } else {
                    System.out.println("Product not found.");
                }
                break;
            case 3:
                System.out.print("Enter product ID to delete: ");
                int deleteId = scanner.nextInt();
                scanner.nextLine();

                Product productToDelete = Product.findProductById(deleteId);
                if (productToDelete != null) {
                    Product.productList.remove(productToDelete);
                    System.out.println("Product deleted successfully!");
                } else {
                    System.out.println("Product not found.");
                }
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid option. Please choose again.");
                break;
        }
    }
}
