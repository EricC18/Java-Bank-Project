/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mybank;

/**
 *
 * @author ericl
 */
import java.io.*;
import java.util.*;

public class MyBank {
    private static final String BANK_FILE = "bank.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = loadBank();

        while (true) {
            System.out.println("|*****************************|");
            System.out.println("|***Welcome To Navy Federal***|");
            System.out.println("|*****************************|");
            System.out.println("\nMenu:");
            System.out.println("1. Add/Update Bank");
            System.out.println("2. Add/Update Employee");
            System.out.println("3. Add/Update Customer");
            System.out.println("4. Add/Update Account");
            System.out.println("5. Show Employees");
            System.out.println("6. Show Customers");
            System.out.println("7. Show Accounts");
            System.out.println("8. Search Customer by ID");
            System.out.println("9. Search Employee by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    handleAddOrUpdateBank(bank, scanner);
                    break;
                case 2:
                    handleAddOrUpdateEmployee(bank, scanner);
                    break;
                case 3:
                    handleAddOrUpdateCustomer(bank, scanner);
                    break;
                case 4:
                    handleAddOrUpdateAccount(bank, scanner);
                    break;
                case 5:
                    showEmployees(bank);
                    break;
                case 6:
                    showCustomers(bank);
                    break;
                case 7:
                    showAccounts(bank);
                    break;
                case 8:
                    searchCustomerById(bank, scanner);
                    break;
                case 9:
                    searchEmployeeById(bank, scanner);
                    break;
                case 0:
                    saveBank(bank);
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the loop and program
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static Bank loadBank() {
        File file = new File(BANK_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Bank) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new Bank("Default Bank");
    }

    private static void saveBank(Bank bank) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BANK_FILE))) {
            oos.writeObject(bank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showEmployees(Bank bank) {
        for (Employee employee : bank.getEmployees()) {
            System.out.println(employee.getId() + ": " + employee.getName() + " (" + employee.getType() + ")");
        }
    }

    private static void showCustomers(Bank bank) {
        for (Customer customer : bank.getCustomers()) {
            System.out.println(customer.getId() + ": " + customer.getName() + " (" + customer.getType() + ")");
        }
    }

    private static void showAccounts(Bank bank) {
        for (Account account : bank.getAccounts()) {
            System.out.println(account.getId() + ": " + account.getBalance() + " (" + account.getType() + ")");
        }
    }

    private static void searchCustomerById(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        for (Customer customer : bank.getCustomers()) {
            if (customer.getId().equals(id)) {
                System.out.println("Found: " + customer.getId() + ": " + customer.getName() + " (" + customer.getType() + ")");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private static void searchEmployeeById(Bank bank, Scanner scanner) {
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        for (Employee employee : bank.getEmployees()) {
            if (employee.getId().equals(id)) {
                System.out.println("Found: " + employee.getId() + ": " + employee.getName() + " (" + employee.getType() + ")");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void handleAddOrUpdateBank(Bank bank, Scanner scanner) {
        System.out.print("Enter bank name: ");
        String name = scanner.nextLine();
        bank.setName(name);
        System.out.println("Bank updated.");
    }

    private static void handleAddOrUpdateEmployee(Bank bank, Scanner scanner) {
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee type (FULL_TIME/PART_TIME): ");
        String typeInput = scanner.nextLine().toUpperCase();
        EmployeeType type;

        try {
            type = EmployeeType.valueOf(typeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid employee type.");
            return;
        }

        boolean found = false;
        for (Employee employee : bank.getEmployees()) {
            if (employee.getId().equals(id)) {
                employee.setName(name);
                employee.setType(type);
                found = true;
                System.out.println("Employee updated.");
                break;
            }
        }
        if (!found) {
            bank.addEmployee(new Employee(id, name, type));
            System.out.println("Employee added.");
        }
            System.out.println("\nCurrent Employees: ");
            showEmployees(bank);
    }
    


    private static void handleAddOrUpdateCustomer(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer type (INDIVIDUAL/BUSINESS): ");
        String typeInput = scanner.nextLine().toUpperCase();
        CustomerType type;

        try {
            type = CustomerType.valueOf(typeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid customer type.");
            return;
        }

        boolean found = false;
        for (Customer customer : bank.getCustomers()) {
            if (customer.getId().equals(id)) {
                customer.setName(name);
                customer.setType(type);
                found = true;
                System.out.println("Customer updated.");
                break;
            }
        }
        if (!found) {
            bank.addCustomer(new Customer(id, name, type));
            System.out.println("Customer added.");
        }
    }

    private static void handleAddOrUpdateAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter account balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter account type (CHECKING/SAVINGS/FIXED_DEPOSIT): ");
        String typeInput = scanner.nextLine().toUpperCase();
        AccountType type;

        try {
            type = AccountType.valueOf(typeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid account type.");
            return;
        }

        boolean found = false;
        for (Account account : bank.getAccounts()) {
            if (account.getId().equals(id)) {
                account.setBalance(balance);
                account.setType(type);
                found = true;
                System.out.println("Account updated.");
                break;
            }
        }
        if (!found) {
            Account account;
            switch (type) {
                case CHECKING:
                    account = new Checking(id, balance);
                    break;
                case SAVINGS:
                    account = new Savings(id, balance);
                    break;
                case FIXED_DEPOSIT:
                    account = new FixedDeposit(id, balance);
                    break;
                default:
                    System.out.println("Invalid account type.");
                    return;
            }
            bank.addAccount(account);
            System.out.println("Account added.");
        }
    }
}





