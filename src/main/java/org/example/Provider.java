package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Provider {
    private String name;
    private String contactInfo;
    private Map<String, Product> products; // Mapa de productos asociados al proveedor

    public Provider(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.products = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
        product.setProvider(this);
    }

    public boolean removeProduct(String productName) {
        if (products.containsKey(productName)) {
            products.remove(productName);
            return true;
        }
        return false;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void generateReport() {
        System.out.println("Proveedor: " + name);
        System.out.println("Información de contacto: " + contactInfo);
        System.out.println("Productos asociados:");
        for (Product product : products.values()) {
            System.out.println("- " + product.getName());
        }
    }
}
