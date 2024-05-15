package org.example;

import java.util.List;
import java.util.Map;

public class report {
    public static void generateClientSalesReport(Map<user, List<sale>> clientSales) {
        System.out.println("Informe de Clientes y Ventas Asociadas:");
        for (Map.Entry<user, List<sale>> entry : clientSales.entrySet()) {
            user client = entry.getKey();
            List<sale> sales = entry.getValue();

            System.out.println("Cliente: " + client.getUserName());
            System.out.println("Ventas:");

            for (sale sale : sales) {
                System.out.println("- ID Venta: " + sale.getSaleId() + ", Monto: " + sale.getAmount());
            }
            System.out.println("-------------------------------------");
        }
    }

    // Método para generar un informe de ventas
    public static void generateSalesReport(List<sale> sales) {
        System.out.println("Informe de Ventas:");
        for (sale sale : sales) {
            System.out.println("- ID Venta: " + sale.getSaleId() + ", Cliente: " + sale.getClient().getUserName() + ", Monto: " + sale.getAmount());
        }
    }

    // Método para generar un informe de inventario
    public static void generateInventoryReport(List<product> products) {
        System.out.println("Informe de Inventario:");
        for (product product : products) {
            System.out.println("- ID: " + product.getId() + ", Nombre: " + product.getName() + ", Cantidad en Stock: " + product.getStockQuantity());
        }
    }

    // Método para generar un informe de proveedores y productos asociados a cada proveedor
    public static void generateProviderProductsReport(List<provider> providers) {
        System.out.println("Informe de Proveedores y Productos Asociados:");
        for (provider provider : providers) {
            System.out.println("Proveedor: " + provider.getName());
            List<product> products = provider.getProducts();
            System.out.println("Productos Asociados:");
            for (product product : products) {
                System.out.println("- Nombre: " + product.getName() + ", Precio: " + product.getPrice());
            }
            System.out.println("-------------------------------------");
        }
    }
}
