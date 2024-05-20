package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sale {
    /*
    Atributos: ID de venta, productos vendidos, total de la venta, fecha y hora.
    Métodos: método para agregar productos a la venta, método para calcular el total de
    la venta.
    */
    private int saleId;
    private String userName;
    private String date;
    private String time;
    private List<Product> productsSold;
    private double totalPrice;
    private double totalDiscount;

    private static List<Sale> sales = new ArrayList<>();
    private static int nextSaleId = 1;

    public Sale(String userName, String date, String time) {
        this.saleId = nextSaleId++;
        this.userName = userName;
        this.date = date;
        this.time = time;
        this.productsSold = new ArrayList<>();
    }

    public static void manageSales(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n--> Sales Management:");
            System.out.println("  1. Create New Sale");
            System.out.println("  2. Back");
            System.out.print("\n Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createSale(scanner);
                    break;
                case 2:
                    back = true;
                    break;
                default:
                    System.out.println("\nInvalid option. Please select a valid option from the menu.");
                    break;
            }
        }
    }

    public static void createSale(Scanner scanner) {
        System.out.print("\nEnter the buyer's name: ");
        String buyerName = scanner.nextLine();

        System.out.print("\nEnter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("\nEnter time (HH:MM): ");
        String time = scanner.nextLine();

        Sale sale = new Sale(buyerName, date, time);

        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("Enter product name to add (or 'done' to finish): ");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("done")) {
                addingProducts = false;
            } else {
                Product product = Product.findProductByName(productName);
                if (product != null) {
                    sale.addProduct(product);
                    System.out.println("Product added to sale!");
                } else {
                    System.out.println("Product not found.");
                }
            }
        }

        System.out.println("Sale created successfully!");
        sales.add(sale);
    }

    public void addProduct(Product product) {
        if (product.hasStock()) {
            productsSold.add(product);
            totalPrice += product.getPrice();
            product.decrementStock(1);
        } else {
            System.out.println("Product out of stock.");
        }
    }

    public void addDiscount(double discount) {
        totalDiscount += discount;
    }

    public int getSaleId() {
        return saleId;
    }

    public String getDate() {
        return date;
    }

    public static List<Sale> getSales() {
        return sales;
    }

    public String getTime() {
        return time;
    }

    public String getUserName() {
        return userName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public String toString() {
        return "Sale ID: " + saleId +
                ", User: " + userName +
                ", Date: " + date +
                ", Time: " + time +
                ", Total Price: $" + totalPrice +
                ", Products Sold: " + productsSold;
    }
}