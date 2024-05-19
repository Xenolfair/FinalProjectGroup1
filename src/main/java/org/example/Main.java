package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User userCurrent = null;
        boolean leave = false;
        System.out.println("Welcome to the Inventory Management System for a very inefficient Electronics Store!");
        while (!leave) {
            System.out.println("\n--> Menu:");
            System.out.println("  1. Login");
            System.out.println("  2. Register new user");
            System.out.println("  3. Leave");
            System.out.print("\n Choose an option: ");

            int optionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (optionMenu) {
                case 1:
                    System.out.print("\nEnter your username: ");
                    String nameUser = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String UserID = scanner.nextLine();

                    userCurrent = User.login(nameUser, UserID);
                    if (userCurrent != null) {
                        System.out.println("\nSuccessful login!");

                        //Aquí el menu funcional luego del login
                    } else {
                        System.out.println("\nIncorrect user name or ID. Please try again");
                    }
                    break;
                case 2:
                    userCurrent = User.registerUser();
                    if (userCurrent != null) {
                        if (userCurrent.getRole() == 3) {
                            AdminMenu.showMenuAdmin(userCurrent, scanner);
                        } else {
                            if (userCurrent.getRole() == 2) {
                                SellerMenu.showMenuSeller(userCurrent, scanner);
                            } else {
                                ManagerMenu.showMenuManager(userCurrent, scanner);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nSee you soon!");
                    leave = true;
                    break;
                default:
                    System.out.println("\nInvalid option. Please select a valid option from the menu");
            }
        }
    }
}

        /*
        para crear nuevo usuario:
                // Mapa para almacenar los usuarios registrados, usando el nombre de usuario como clave
            private static Map<String, User> users = new HashMap<>();

            public static void main(String[] args) {
                // Registro de un nuevo usuario
                registerUser("user123", "password123", "cliente");

                // Verificación de que el usuario se ha registrado correctamente
                User user = users.get("user123");
                if (user != null) {
                    System.out.println("Usuario registrado con éxito:");
                    System.out.println("Nombre de usuario: " + user.getUserName());
                    System.out.println("Rol: " + user.getRole());
                    // Otros detalles del usuario si es necesario
                } else {
                    System.out.println("No se pudo registrar el usuario.");
                }
            }

            // Método para registrar un nuevo usuario
            private static void registerUser(String userName, String password, String role) {
                // Verificar si el nombre de usuario ya existe
                if (users.containsKey(userName)) {
                    System.out.println("El nombre de usuario ya está en uso. Por favor, elija otro.");
                } else {
                    // Crear una nueva instancia de User y agregarla al mapa de usuarios
                    User newUser = new User(userName, password, role);
                    users.put(userName, newUser);
                    System.out.println("Usuario registrado con éxito.");
                }
            }
                 */

        //product product1 = new product();

        //Asi se agrega producto:
        //product1.addPromotion("Oferta especial", 0.15); // Descuento del 15%

        // Verificar si el producto tiene una promoción específica
        /*if (product1.hasPromotion("Oferta especial")) {
            System.out.println("El producto tiene una promoción especial.");
        } else {
            System.out.println("El producto no tiene una promoción especial.");
        }*/

        // Actualizar el stock del producto
        //product1.updateStock(10);

        // Mostrar el stock actual del producto
        //System.out.println("Stock actual del producto: " + product1.getStockQuantity());

        // Crear un nuevo usuario
        //User user1 = new User("usuario1", "contraseña123", "cliente");

        // Asignar puntos de fidelidad al usuario por una compra realizada
        //user1.addLoyaltyPoints(50);

        // Verificar el saldo de puntos de fidelidad del usuario
        //System.out.println("Saldo de puntos de fidelidad del usuario: " + user1.getLoyaltyPoints());

        // Canjear puntos de fidelidad por un descuento
        //int puntosACanjear = 30;
        /*if (user1.redeemLoyaltyPoints(puntosACanjear)) {
            System.out.println("Se han canjeado " + puntosACanjear + " puntos por un descuento.");
        } else {
            System.out.println("No hay puntos suficientes para canjear por descuento.");
        }*/

        // Verificar el saldo de puntos de fidelidad actualizado
        //System.out.println("Saldo de puntos de fidelidad del usuario después del canje: " + user1.getLoyaltyPoints());

        // Registrar una transacción de puntos de fidelidad
        //user1.recordLoyaltyTransaction("Compra", 50);

        // Obtener el historial de transacciones de puntos de fidelidad del usuario
        /*Map<String, Integer> historialTransacciones = user1.getLoyaltyTransactions();
        System.out.println("Historial de transacciones de puntos de fidelidad:");
        for (Map.Entry<String, Integer> entry : historialTransacciones.entrySet()) {
            System.out.println("Tipo de transacción: " + entry.getKey() + ", Puntos: " + entry.getValue());
        }*/

        // Crear un proveedor
        //Provider provider1 = new Provider("ElectroPro", "contacto@electropro.com");

        // Crear un producto y asociarlo al proveedor
        /*Product product1 = new Product(1, "Laptop", "Portátil de alta gama", 1500.0, 10);
        product1.setProvider(provider1);
        provider1.addProduct(product1);*/

        // Obtener el proveedor de un producto
        /*Provider product1Provider = product1.getProvider();
        System.out.println("El proveedor del producto es: " + product1Provider.getName());*/

        // Obtener los productos asociados a un proveedor
        /*List<Product> provider1Products = provider1.getProducts();
        System.out.println("Productos asociados al proveedor: " + provider1.getName());
        for (Product product : provider1Products) {
            System.out.println("- " + product.getName());
        }*/
