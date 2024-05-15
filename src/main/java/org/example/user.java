package org.example;

import java.util.HashMap;
import java.util.Map;

public class user {
    /*
        Atributos: nombre de usuario, contraseña, rol.
        Métodos: getters y setters para los atributos, método para verificar la contraseña.
    */
    private String userName;
    private String password;
    private String role;
    private int loyaltyPoints;
    private Map<String, Integer> loyaltyTransactions;

    public user(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.loyaltyPoints = 0;
        this.loyaltyTransactions = new HashMap<>();
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
