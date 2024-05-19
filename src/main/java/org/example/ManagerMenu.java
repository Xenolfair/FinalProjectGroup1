package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMenu {
    public static void showMenuManager( User user, Scanner scanner) {
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
                    Sale.performSale(scanner);
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
}
