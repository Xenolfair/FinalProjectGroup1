package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Product {
/*
    Atributos: ID, nombre, descripción, precio, cantidad en stock.
    Métodos: getters y setters para los atributos, método para actualizar la cantidad en
    stock.
*/
    private int id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Provider provider;
    private Map<String, Double> promotions;
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

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public boolean hasStock() {
        return stockQuantity > 0;
    }

    public void decrementStock() {
        if (stockQuantity > 0) {
            stockQuantity--;
        }
    }

    public void addPromotion(Promotion promotion) {
        promotions.put(promotion.getName(), promotion.getDiscount());
    }

    public boolean removePromotion(String promotionName) {
        return promotions.remove(promotionName) != null;
    }

    public Map<String, Double> getPromotions() {
        return promotions;
    }

    public boolean hasPromotion(String promotionName) {
        return promotions.containsKey(promotionName);
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
