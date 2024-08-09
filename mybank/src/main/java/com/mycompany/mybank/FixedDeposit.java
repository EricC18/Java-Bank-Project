/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mybank;

/**
 *
 * @author ericl
 */
public class FixedDeposit extends Account {
    public FixedDeposit(String id, double balance) {
        super(id, balance, AccountType.FIXED_DEPOSIT);
    }
}


