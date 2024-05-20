package org.example;

import java.util.List;

public class Report {
    public static void viewInventory() {
        if (Product.productList.isEmpty()) {
            System.out.println(" * No inventory available.");
        } else {
            System.out.println("--> Current Inventory:");
            for (Product product : Product.productList) {
                System.out.println(product);
            }
        }
    }

    public static void generateSalesReport() {
        List<Sale> sales = Sale.getSales();

        if (sales.isEmpty()) {
            System.out.println("No sales available.");
        } else {
            System.out.println("Sales Report:");
            for (Sale sale : sales) {
                System.out.println(sale);
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
