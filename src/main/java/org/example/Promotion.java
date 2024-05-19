package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Promotion {
    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private double discount;

    private static List<Promotion> promotions = new ArrayList<>();

    public Promotion(String name, String startDate, String endDate, String description, double discount) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.discount = discount;
    }

    public static void managePromotions(Scanner scanner) {
        boolean leave = false;

        while (!leave) {
            System.out.println("\n--> Promotion Management:");
            System.out.println("  1. Create Promotion");
            System.out.println("  2. Apply Promotion to Product");
            System.out.println("  3. Remove Promotion from Product");
            System.out.println("  4. View All Promotions");
            System.out.println("  5. Back");
            System.out.print("\n --> Choose an option: ");

            int promoOption = scanner.nextInt();
            scanner.nextLine();

            switch (promoOption) {
                case 1:
                    createPromotion(scanner);
                    break;
                case 2:
                    applyPromotionToProduct(scanner);
                    break;
                case 3:
                    removePromotionFromProduct(scanner);
                    break;
                case 4:
                    viewAllPromotions();
                    break;
                case 5:
                    leave = true;
                    break;
                default:
                    System.out.println("\nInvalid option. Please select a valid option from the menu");
                    break;
            }
        }
    }

    public static void createPromotion(Scanner scanner) {
        System.out.print("Enter promotion name: ");
        String name = scanner.nextLine();

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter discount (%): ");
        double discount = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        // Crear la promoción y añadirla a la lista
        Promotion promotion = new Promotion(name, startDate, endDate, description, discount);
        addPromotion(promotion);
        System.out.println("Promotion created successfully!");
    }

    public static void applyPromotionToProduct(Scanner scanner) {
        System.out.print("Enter product name to apply promotion: ");
        String productName = scanner.nextLine();

        // Buscar el producto por nombre
        Product product = Product.findProductByName(productName);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter promotion name to apply: ");
        String promotionName = scanner.nextLine();

        // Buscar la promoción por nombre
        Promotion promotion = findPromotionByName(promotionName);
        if (promotion == null) {
            System.out.println("Promotion not found.");
            return;
        }

        // Aplicar la promoción al producto
        product.addPromotion(promotion);
        System.out.println("Promotion applied to product successfully!");
    }

    public static Promotion findPromotionByName(String promotionName) {
        for (Promotion promotion : promotions) {
            if (promotion.getName().equalsIgnoreCase(promotionName)) {
                return promotion;
            }
        }
        return null;
    }
    public static void removePromotionFromProduct(Scanner scanner) {
        System.out.print("Enter product name to remove promotion: ");
        String productName = scanner.nextLine();

        // Buscar el producto por nombre
        Product product = Product.findProductByName(productName);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        // Verificar si el producto tiene alguna promoción aplicada
        if (product.getPromotions().isEmpty()) {
            System.out.println("Product does not have any promotions applied.");
            return;
        }

        System.out.print("Enter promotion name to remove: ");
        String promotionName = scanner.nextLine();

        // Eliminar la promoción del producto
        if (product.removePromotion(promotionName)) {
            System.out.println("Promotion removed from product successfully!");
        } else {
            System.out.println("Failed to remove promotion from product.");
        }
    }

    public static void viewAllPromotions() {
        List<Promotion> promotions = getPromotions();

        if (promotions.isEmpty()) {
            System.out.println("No promotions available.");
        } else {
            System.out.println("All Promotions:");
            for (Promotion promotion : promotions) {
                System.out.println(promotion);
            }
        }
    }
    public static void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public static List<Promotion> getPromotions() {
        return promotions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Promotion: " +
                "Name='" + name + '\'' +
                ", Start Date='" + startDate + '\'' +
                ", End Date='" + endDate + '\'' +
                ", Description='" + description + '\'' +
                ", Discount=" + (discount * 100) + "%";
    }
}