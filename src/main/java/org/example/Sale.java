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
    private List<Product> soldProducts;
    private double totalSaleAmount;
    private String dateSale;
    private String timeSale;
    private User client;
    public static List<Sale> salesList = new ArrayList<>();

    public Sale(int saleId, String dateSale, String timeSale) {
        this.saleId = saleId;
        this.soldProducts = new ArrayList<>();
        this.totalSaleAmount = 0.0;
        this.dateSale = dateSale;
        this.timeSale = timeSale;
    }

    public void addProduct(Product product) {
        if (product.hasStock()) {
            soldProducts.add(product);
            product.decrementStock();
            calculateTotalSaleAmount();
        } else {
            System.out.println("The product " + product.getName() + " is out of stock and cannot be added to the sale.");
        }
    }

    public static void manageSales(Scanner scanner, List<Sale> salesList) {
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
                    System.out.print("Enter Sale ID: ");
                    int saleId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Sale Date (YYYY-MM-DD): ");
                    String dateSale = scanner.nextLine();

                    System.out.print("Enter Sale Time (HH:MM): ");
                    String timeSale = scanner.nextLine();

                    Sale newSale = new Sale(saleId, dateSale, timeSale);

                    boolean addingProducts = true;
                    while (addingProducts) {
                        System.out.print("Enter Product Name to add (or 'done' to finish): ");
                        String productName = scanner.nextLine();

                        if (productName.equalsIgnoreCase("done")) {
                            addingProducts = false;
                        } else {
                            Product product = Product.findProductByName(productName);
                            if (product != null) {
                                if (product.hasStock()) {
                                    product.decrementStock();
                                    newSale.addProduct(product);
                                    System.out.println("Product added to sale!");
                                } else {
                                    System.out.println("Product out of stock.");
                                }
                            } else {
                                System.out.println("Product not found.");
                            }
                        }
                    }

                    newSale.calculateTotalSaleAmount();
                    salesList.add(newSale);
                    System.out.println("Sale created successfully with total amount: " + newSale.getTotalSaleAmount());
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

    private void calculateTotalSaleAmount() {
        totalSaleAmount = 0.0;
        for (Product product : soldProducts) {
            totalSaleAmount += product.getPrice();
        }
    }

    public int getSaleId() {
        return saleId;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public List<Product> getSoldProducts() {
        return soldProducts;
    }


    @Override
    public String toString() {
        return "Sale ID: " + saleId + ", Total Amount: " + totalSaleAmount + ", Date: " + dateSale + ", Time: " + timeSale + ", Client: " + (client != null ? client.getUserName() : "N/A");
    }
}