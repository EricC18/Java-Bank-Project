/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mybank;

/**
 *
 * @author ericl
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<Employee> employees;
    private List<Customer> customers;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }
}


