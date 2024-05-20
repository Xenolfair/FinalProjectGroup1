package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Provider {
    private int id;
    private String name;
    private String contactInfo;
    private List<Product> providedProducts;
    private static List<Provider> providerList = new ArrayList<>();


    public Provider(int id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.providedProducts = new ArrayList<>();
    }

    public static void manageProviders(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n--> Provider Management:");
            System.out.println("          1. Add New Provider");
            System.out.println("          2. Modify Provider");
            System.out.println("          3. Remove Provider");
            System.out.println("          4. View Providers");
            System.out.println("          5. Associate Product with Provider");
            System.out.println("          6. View Products by Provider");
            System.out.println("          7. Edit Product Stock");
            System.out.println("          8. Back");
            System.out.print("\n Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Provider ID: ");
                    int providerId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Provider Name: ");
                    String providerName = scanner.nextLine();

                    System.out.print("Enter Provider Contact Info: ");
                    String providerContactInfo = scanner.nextLine();

                    Provider newProvider = new Provider(providerId, providerName, providerContactInfo);
                    providerList.add(newProvider);
                    System.out.println("Provider added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Provider ID to modify: ");
                    providerId = scanner.nextInt();
                    scanner.nextLine();

                    Provider providerToModify = findProviderById(providerId);
                    if (providerToModify != null) {
                        System.out.print("Enter new Provider Name: ");
                        providerName = scanner.nextLine();

                        System.out.print("Enter new Provider Contact Info: ");
                        providerContactInfo = scanner.nextLine();

                        providerToModify.setName(providerName);
                        providerToModify.setContactInfo(providerContactInfo);
                        System.out.println("Provider modified successfully!");
                    } else {
                        System.out.println("Provider not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Provider ID to remove: ");
                    providerId = scanner.nextInt();
                    scanner.nextLine();

                    Provider providerToRemove = findProviderById(providerId);
                    if (providerToRemove != null) {
                        providerList.remove(providerToRemove);
                        System.out.println("Provider removed successfully!");
                    } else {
                        System.out.println("Provider not found.");
                    }
                    break;
                case 4:
                    System.out.println("--> All Providers:");
                    if (providerList.isEmpty()) {
                        System.out.println("No providers available.");
                    } else {
                        for (Provider provider : providerList) {
                            System.out.println(provider);
                            System.out.println("Products from this provider:");
                            for (Product product : provider.getProvidedProducts()) {
                                System.out.println(product);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter Provider ID: ");
                    providerId = scanner.nextInt();
                    scanner.nextLine();

                    Provider provider = findProviderById(providerId);
                    if (provider != null) {
                        boolean associatingProducts = true;
                        while (associatingProducts) {
                            System.out.print("Enter Product Name to associate (or 'done' to finish): ");
                            String productName = scanner.nextLine();

                            if (productName.equalsIgnoreCase("done")) {
                                associatingProducts = false;
                            } else {
                                Product product = Product.findProductByName(productName);
                                if (product != null) {
                                    provider.addProduct(product);
                                    System.out.println("Product associated with provider!");
                                } else {
                                    System.out.println("Product not found.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Provider not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Provider ID: ");
                    providerId = scanner.nextInt();
                    scanner.nextLine();

                    provider = findProviderById(providerId);
                    if (provider != null) {
                        System.out.println("Products from this provider:");
                        for (Product product : provider.getProvidedProducts()) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("Provider not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter Provider ID: ");
                    providerId = scanner.nextInt();
                    scanner.nextLine();

                    provider = findProviderById(providerId);
                    if (provider != null) {
                        System.out.print("Enter Product Name to edit stock: ");
                        String productName = scanner.nextLine();

                        Product product = Product.findProductByName(productName);
                        if (product != null && provider.getProvidedProducts().contains(product)) {
                            System.out.print("Enter new stock quantity: ");
                            int newStockQuantity = scanner.nextInt();
                            scanner.nextLine();

                            product.setStockQuantity(newStockQuantity);
                            System.out.println("Product stock updated successfully!");
                        } else {
                            System.out.println("Product not found or not associated with this provider.");
                        }
                    } else {
                        System.out.println("Provider not found.");
                    }
                    break;
                case 8:
                    back = true;
                    break;
                default:
                    System.out.println("\nInvalid option. Please select a valid option from the menu.");
                    break;
            }
        }
    }

    private static Provider findProviderById(int providerId) {
        for (Provider provider : providerList) {
            if (provider.getId() == providerId) {
                return provider;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Product> getProvidedProducts() {
        return providedProducts;
    }

    public void addProduct(Product product) {
        if (!providedProducts.contains(product)) {
            providedProducts.add(product);
            product.setProvider(this);
        }
    }

    public void removeProduct(Product product) {
        if (providedProducts.contains(product)) {
            providedProducts.remove(product);
            product.setProvider(null);
        }
    }

    @Override
    public String toString() {
        return "Provider ID: " + id + ", Name: " + name + ", Contact Info: " + contactInfo;
    }
}