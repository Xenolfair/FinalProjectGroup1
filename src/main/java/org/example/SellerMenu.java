package org.example;

import java.util.Scanner;

public class SellerMenu {
    public static void showMenuSeller( User user, Scanner scanner) {
        boolean leave = false;

        while (!leave) {
            System.out.println("\n--> Options: ");
            System.out.println("          1. View Inventory");
            System.out.println("          2. Perform Sale");
            System.out.println("          3. Exit");
            System.out.print("\n --> Choose an option: ");

            int userElection = scanner.nextInt();
            switch (userElection) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    performSale(scanner);
                    break;
                case 3:
                    System.out.println("See you soon...");
                    leave = true;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
                    break;
            }
        }
    }

    public static void viewInventory() {
        System.out.println("\n--> Current Inventory:");
        for (Product product : Product.productList) {
            System.out.println(product);
        }
    }

    public static void performSale(Scanner scanner) {
        System.out.print("Enter product ID to sell: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = Product.findProductById(productId);
        if (product != null) {
            System.out.print("Enter quantity to sell: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            if (quantity <= product.getStockQuantity()) {
                product.setStockQuantity(product.getStockQuantity() - quantity);
                System.out.println("Sale successful! Remaining stock: " + product.getStockQuantity());
            } else {
                System.out.println("Insufficient stock for this sale.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }
}

