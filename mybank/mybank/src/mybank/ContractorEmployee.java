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
public class ContractorEmployee extends Employee {
    private float hourlyRate ;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public ContractorEmployee(float hourlyRate, int id, String name, String email) {
        super(id, name, email);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "ContractorEmployee{" + "hourlyRate=" + hourlyRate +" " + super.toString() + '}';
    }
    
}
