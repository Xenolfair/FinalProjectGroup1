package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class provider {
    private String name;
    private String contactInfo;
    private Map<String, product> products; // Mapa de productos asociados al proveedor

    public provider(String name, String contactInfo) {
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

    public void addProduct(product product) {
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

    public List<product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void generateReport() {
        System.out.println("Proveedor: " + name);
        System.out.println("Información de contacto: " + contactInfo);
        System.out.println("Productos asociados:");
        for (product product : products.values()) {
            System.out.println("- " + product.getName());
        }
    }
}
