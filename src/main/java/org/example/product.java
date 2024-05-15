package org.example;

import java.util.HashMap;
import java.util.Map;

public class product {
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
    private Map<String, Double> promotions; // Mapa de promociones por nombre de promoción y descuento

    public product(int id, String name, String description, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.promotions = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
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

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void addPromotion(String promotionName, double discount) {
        promotions.put(promotionName, discount);
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
}
