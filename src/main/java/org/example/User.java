package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    /*
        Atributos: nombre de usuario, contraseña, rol.
        Métodos: getters y setters para los atributos, método para verificar la contraseña.
    */

    private String userName;
    private String password;
    private int role;
    private int loyaltyPoints;
    private Map<String, Integer> loyaltyTransactions;
    public static ArrayList<User> usersRegistered = new ArrayList<>();

    public User(String userName, String password, int role) {
        this.userName = userName;
        this.password = password;
        this.role = 0;
        this.loyaltyPoints = 0;
        this.loyaltyTransactions = new HashMap<>();
        usersRegistered.add(this);
    }

    public static User login(String nameUser, String password) {
        System.out.println("--> Welcome to the user login system!");
        for (User user : usersRegistered) {
            if (user.getUserName().equals(nameUser) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static User registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--> Welcome to the user registration system!");

        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Now, enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Also, enter your role (1)Seller,(2)Manager, (3)Admin: ");
        int role = scanner.nextInt();
        scanner.nextLine();

        User user = new User(userName, password, role);

        System.out.println("\nSuccessful registration!");
        System.out.println("--> User data:");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Password: " + user.getPassword());

        String roleString;

        if (role == 1) {
            roleString = "Vendedor";
        } else if (role == 2) {
            roleString = "Manager";
        } else if (role == 3) {
            roleString = "Admin";
        } else {
            roleString = "User";
        }

        System.out.println("Role: " + roleString);

        return user;
    }

    public static void showUsersRegistered() {
        if (usersRegistered.isEmpty()) {
            System.out.println("There are no registered users");
        } else {
            for (User user : usersRegistered) {
                System.out.println("Name: " + user.getUserName() + ", Password: " + user.getPassword() + ", Role: " + (user.getRole() == 2 ? "Admin" : "User"));
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public boolean redeemLoyaltyPoints(int points) {
        if (loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
            return true;
        } else {
            return false;
        }
    }

    public void recordLoyaltyTransaction(String transactionType, int points) {
        loyaltyTransactions.put(transactionType, points);
    }

    public Map<String, Integer> getLoyaltyTransactions() {
        return loyaltyTransactions;
    }
}
