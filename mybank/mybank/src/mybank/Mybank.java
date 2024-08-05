/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author itexps
 */
public class Mybank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        //empty employee list
        ArrayList<Employee> employees = new ArrayList<Employee>();
        //create a bank with empty employee list
        Bank bank = new Bank(1, "IT Expert Bank", "847 350 9034", employees);
        do {
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("== Add employee==");
                    System.out.println("Enter id");
                    int id = sc.nextInt();
                    System.out.println("Enter name");
                    String name = sc.next();

                    System.out.println("Enter email");
                    String email = sc.next();

                    System.out.println("Employee type");
                    String type = sc.next();
                    Employee emp1 = null;
                    if (type.equalsIgnoreCase("fulltime")) {
                        //create employee instance with data
                        System.out.println("Enter salary");
                        float salary = sc.nextFloat();
                        emp1 = new FullTiimeEmployee(salary, id, name, email);
                    } else {
                        System.out.println("Enter hourly rate");
                        float hourlyrate = sc.nextFloat();
                        emp1 = new ContractorEmployee(hourlyrate, id, name, email);
                    }

                    //add employee in a bank
                    bank.getEmployees().add(emp1);
                    System.out.println(bank);
                    break;
                case 2:
                    System.out.println("== Search employee == ");
                    System.out.println("Enter employee id ");
                    int eid = sc.nextInt();
                    boolean found = false;
                    for (Employee e : bank.getEmployees()) {
                        if (e.getId() == eid) {
                            System.out.println(e);
                            found = true;
                            break;
                        }
                    }
                    if (found == false) {
                        System.out.println("For this id - Employee does not exit");
                    }
                    break;
                case 3:
                    System.out.println("Save Employee");
                    try {
                        FileWriter fw = new FileWriter("c:\\data\\bank.txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write ("===========Bank ============\n");
                        bw.write(bank.getId() + "|" + bank.getName() + "|" + bank.getPhone() + "\n");
                       
                        bw.write ("===========Employee[s] ============\n");

                        for (Employee e : bank.getEmployees()) {

                            bw.write(e.getId() + "|" + e.getName() + "|" + e.getEmail());
                            if (e instanceof FullTiimeEmployee) {
                                bw.write(((FullTiimeEmployee) e).getSalary() + "");
                            } else {
                                bw.write(((ContractorEmployee) e).getHourlyRate() + "");
                            }
                            bw.write("\n");
                           
                        } //for
                        
                        //TODO For Customer
                        
                        //Each Customer has account
                        
                      bw.close();
                      fw.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    break;
            }

        } while (choice != 4);

    }

    public static void menu() {
        System.out.println("1 for Add Employee");
        System.out.println("2 for Search Employee");
        System.out.println("3 for Save Employee");

        System.out.println("4 for Quit");
        System.out.println("Enter your choice  ");
    }
}
