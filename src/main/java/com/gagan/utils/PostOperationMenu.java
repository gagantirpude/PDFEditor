package com.gagan.utils;


import java.util.Scanner;

public class PostOperationMenu {
    public static void display(Scanner scanner, Runnable currentOperation, Runnable mainMenu) {
        while (true) {
            System.out.println("\nOperation completed. Choose an option:");
            System.out.println("1. Return to Main Menu");
            System.out.println("2. Exit Program");
            System.out.println("3. Rerun Current Operation");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    mainMenu.run(); // Return to the main menu
                    return;
                case "2":
                    System.out.println("Exiting PDF Editor. Goodbye!");
                    System.exit(0);
                case "3":
                    currentOperation.run(); // Rerun the current operation
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
