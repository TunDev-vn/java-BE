package buoi13.testmodule2;

import java.util.*;

public class BankManagementSystem {
    private static List<Account> accounts = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Manage Accounts");
            System.out.println("2. Manage Transactions");
            System.out.println("3. Manage Employees");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> manageAccounts();
                case 2 -> manageTransactions();
                case 3 -> manageEmployees();
                case 4 -> {
                    System.out.println("Exiting the system. Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageAccounts() {
        // Manage account operations
    }

    private static void manageTransactions() {
        // Manage transaction operations
    }

    private static void manageEmployees() {
        // Manage employee operations
    }
}
