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
        this.role = role;
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

    public static void showRoleMenu(User user, Scanner scanner) {
        if (user.getRole() == 3) {
            AdminMenu.showMenuAdmin(user, scanner);
        } else if (user.getRole() == 2) {
            SellerMenu.showMenuSeller(user, scanner);
        } else if (user.getRole() == 1) {
            ManagerMenu.showMenuManager(user, scanner);
        } else {
            System.out.println(user.getRole());
            System.out.println("Invalid user role.");
        }
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

    public static void manageUsers(Scanner scanner) {
        System.out.println("\n--> User Management:");
        System.out.println("          1. View All Users");
        System.out.println("          2. Modify User Role");
        System.out.println("          2. Delete user");
        System.out.println("          3. Back");
        System.out.print("\n Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                Report.viewAllUsers();
                break;
            case 2:
                modifyUserRole(scanner);
                break;
            case 3:
                deleteUser(scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("\n Invalid option. Please choose again.");
                break;
        }
    }

    public static void modifyUserRole(Scanner scanner) {
        System.out.print("\nEnter username of the user to modify: ");
        String username = scanner.nextLine();
        User user = findUserByUsername(username);

        if (user != null) {
            System.out.println("Current role: " + user.getRole());
            System.out.print("Enter new role: ");
            int newRole = scanner.nextInt();
            user.setRole(newRole);
            System.out.println("Role updated successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    public static void deleteUser(Scanner scanner) {
        System.out.print("\nEnter username of the user to delete: ");
        String username = scanner.nextLine();
        User user = findUserByUsername(username);

        if (user != null) {
            User.usersRegistered.remove(user);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    public static User findUserByUsername(String username) {
        for (User user : User.usersRegistered) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Username: " + userName + ", Role: " + role;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        int roleUser = role;
        return roleUser;
    }

    public void setRole(int role) {
        this.role = role;
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
