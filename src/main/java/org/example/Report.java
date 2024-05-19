package org.example;

import java.util.List;
import java.util.Map;

public class Report {
    public static void generateInventoryReport() {
        System.out.println("\nGenerating inventory report...");

        for (Product product : Product.productList) {
            System.out.println(product);
        }

        System.out.println("\nInventory report generated successfully!");
    }

    public static void generateSalesReport() {
        if (Sale.salesList.isEmpty()) {
            System.out.println("No sales available.");
        } else {
            for (Sale s : Sale.salesList) {
                System.out.println(s);
                System.out.println("Products sold:");
                for (Product p : s.getSoldProducts()) {
                    System.out.println(p);
                }
            }
        }
    }

    public static void viewAllUsers() {
        System.out.println("\n--> All Users:");
        for (User user : User.usersRegistered) {
            System.out.println(user);
        }
    }
}
