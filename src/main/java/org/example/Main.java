package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User userCurrent = null;
        boolean leave = false;

        System.out.println("\n==> Welcome to the Inventory Management System for a very inefficient Electronics Store!");
        while (!leave) {
            System.out.println("\n--> Menu:");
            System.out.println("  1. Login to registered account");
            System.out.println("  2. Register new user");
            System.out.println("  3. Leave");
            System.out.print("\n Choose an option: ");

            int optionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (optionMenu) {
                case 1:
                    System.out.print("\nEnter your username: ");
                    String nameUser = scanner.nextLine();
                    System.out.print("\nEnter your password: ");
                    String userID = scanner.nextLine();

                    userCurrent = User.login(nameUser, userID);
                    if (userCurrent != null) {
                        System.out.println("\nSuccessful login!");
                        User.showRoleMenu(userCurrent, scanner);
                    } else {
                        System.out.println(" * Login failed. Please check your username and password.");
                    }
                    break;
                case 2:
                    userCurrent = User.registerUser();
                    if (userCurrent != null) {
                        User.showRoleMenu(userCurrent, scanner);
                    }
                    break;
                case 3:
                    System.out.println("\nSee you soon!");
                    leave = true;
                    break;
                default:
                    System.out.println("\n * Invalid option. Please select a valid option from the menu");
                    break;
            }
        }
    }
}