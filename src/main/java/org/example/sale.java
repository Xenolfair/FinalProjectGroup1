package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class sale {
    /*
    Atributos: ID de venta, productos vendidos, total de la venta, fecha y hora.
    Métodos: método para agregar productos a la venta, método para calcular el total de
    la venta.
    */
    private int saleId;
    private List<product> soldProducts;
    private double totalSaleAmount;
    private Date dateTime;

    public sale(int saleId) {
        this.saleId = saleId;
        this.soldProducts = new ArrayList<>();
        this.totalSaleAmount = 0.0;
        this.dateTime = new Date();
    }

    public void addProduct(product product) {
        soldProducts.add(product);
    }

    public void calculateTotalSaleAmount() {
        totalSaleAmount = 0.0;
        for (product product : soldProducts) {
            totalSaleAmount += product.getPrice();
        }
    }

    public int getSaleId() {
        return saleId;
    }

    public List<product> getSoldProducts() {
        return soldProducts;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public Date getDateTime() {
        return dateTime;
    }
}