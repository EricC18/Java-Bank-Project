/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

/**
 *
 * @author itexps
 */
public class FullTiimeEmployee extends Employee {
    private float salary;

    public FullTiimeEmployee(float salary, int id, String name, String email) {
        super(id, name, email);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTiimeEmployee{" + "salary=" + salary + " " + super.toString() + '}';
    }
    
}
