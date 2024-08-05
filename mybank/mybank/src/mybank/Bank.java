/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

import java.util.ArrayList;

/**
 *
 * @author itexps
 */
public class Bank {
    private int id;
    private String name;
    private String phone;
    ArrayList<Employee> employees;

    public Bank(int id, String name, String phone, ArrayList<Employee> employees) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Bank{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", employees=" + employees + '}';
    }
    
    
    
}
