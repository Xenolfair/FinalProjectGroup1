package org.example;

import java.util.Scanner;

public class SellerMenu {
    public static void showMenuSeller( User user, Scanner scanner) {
        boolean leave = false;

        while (!leave) {
            System.out.println("\n--> Options: ");
            System.out.println("          1. View Inventory");
            System.out.println("          2. Perform Sale");
            System.out.println("          3. Log out");
            System.out.print("\n --> Choose an option: ");

            int userElection = scanner.nextInt();
            switch (userElection) {
                case 1:
                    Report.viewInventory();
                    break;
                case 2:
                    Sale.createSale(scanner);
                    break;
                case 3:
                    System.out.println(" * See you soon...");
                    leave = true;
                    break;
                default:
                    System.out.println(" * Invalid option. Please select a valid option.");
                    break;
            }
        }
    }
}

