package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Provider provider;
    private Map<String, Promotion> promotions;
    private List<Promotion> appliedPromotions;
    public static List<Product> productList = new ArrayList<>();

    public Product(int id, String name, String description, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.promotions = new HashMap<>();
        this.appliedPromotions = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Description: " + description + ", Price: " + price + ", Stock Quantity: " + stockQuantity;
    }

    public static Product findProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static Product findProductByName(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public boolean hasStock() {
        return stockQuantity > 0;
    }

    public void decrementStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
        }
    }

    public List<Promotion> getAppliedPromotions() {
        return appliedPromotions;
    }

    public void addPromotion(Promotion promotion) {
        promotions.put(promotion.getName(), promotion);
    }

    public boolean removePromotion(String promotionName) {
        return promotions.remove(promotionName) != null;
    }

    public Map<String, Promotion> getPromotions() {
        return promotions;
    }

    public boolean hasPromotion(String promotionName) {
        return promotions.containsKey(promotionName);
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void purchase(int quantity, String username, Date purchaseDate) {
        if (hasStock() && stockQuantity >= quantity) {
            double finalPrice = price;
            for (Promotion promotion : promotions.values()) {
                if (promotion.isValid(purchaseDate)) {
                    finalPrice -= finalPrice * (promotion.getDiscount() / 100);
                }
            }

            decrementStock(quantity);
            double totalPrice = finalPrice * quantity;
            System.out.println("User " + username + " purchased " + quantity + " units of " + name + " on " + purchaseDate + " at " + finalPrice + " per unit. Total: " + totalPrice);
        } else {
            System.out.println("Insufficient stock for the purchase.");
        }
    }
}