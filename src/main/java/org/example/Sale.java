package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {
    /*
    Atributos: ID de venta, productos vendidos, total de la venta, fecha y hora.
    Métodos: método para agregar productos a la venta, método para calcular el total de
    la venta.
    */
    private int saleId;
    private List<Product> soldProducts;
    private double totalSaleAmount;
    private Date dateTime;
    private User client;

    public Sale(int saleId) {
        this.saleId = saleId;
        this.soldProducts = new ArrayList<>();
        this.totalSaleAmount = 0.0;
        this.dateTime = new Date();
    }

    public void addProduct(Product product) {
        soldProducts.add(product);
    }

    public void calculateTotalSaleAmount() {
        totalSaleAmount = 0.0;
        for (Product product : soldProducts) {
            totalSaleAmount += product.getPrice();
        }
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public double getAmount() {
        return totalSaleAmount;
    }


    public List<Product> getSoldProducts() {
        return soldProducts;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public Date getDateTime() {
        return dateTime;
    }
}