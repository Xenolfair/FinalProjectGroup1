package org.example;

import java.util.List;
import java.util.Map;

public class Report {
    public static void generateClientSalesReport(Map<User, List<Sale>> clientSales) {
        System.out.println("Informe de Clientes y Ventas Asociadas:");
        for (Map.Entry<User, List<Sale>> entry : clientSales.entrySet()) {
            User client = entry.getKey();
            List<Sale> Sales = entry.getValue();

            System.out.println("Cliente: " + client.getUserName());
            System.out.println("Ventas:");

            for (Sale sale : Sales) {
                System.out.println("- ID Venta: " + sale.getSaleId() + ", Monto: " + sale.getAmount());
            }
            System.out.println("-------------------------------------");
        }
    }

    // Método para generar un informe de ventas
    public static void generateSalesReport(List<Sale> Sales) {
        System.out.println("Informe de Ventas:");
        for (Sale sale : Sales) {
            System.out.println("- ID Venta: " + sale.getSaleId() + ", Cliente: " + sale.getClient().getUserName() + ", Monto: " + sale.getAmount());
        }
    }

    // Método para generar un informe de inventario
    public static void generateInventoryReport(List<Product> Products) {
        System.out.println("Informe de Inventario:");
        for (Product product : Products) {
            System.out.println("- ID: " + product.getId() + ", Nombre: " + product.getName() + ", Cantidad en Stock: " + product.getStockQuantity());
        }
    }

    // Método para generar un informe de proveedores y productos asociados a cada proveedor
    public static void generateProviderProductsReport(List<Provider> Providers) {
        System.out.println("Informe de Proveedores y Productos Asociados:");
        for (Provider provider : Providers) {
            System.out.println("Proveedor: " + provider.getName());
            List<Product> Products = provider.getProducts();
            System.out.println("Productos Asociados:");
            for (Product product : Products) {
                System.out.println("- Nombre: " + product.getName() + ", Precio: " + product.getPrice());
            }
            System.out.println("-------------------------------------");
        }
    }
}
