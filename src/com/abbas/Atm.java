package com.abbas;

import java.util.Random;
import java.util.Scanner;

public class Atm {
    
    private int accountNo;
    private int amount;
    private int atmPin;
    
    public Atm() {
        super();
        this.accountNo = new Random().nextInt(10000);
        this.amount = 10000;
        this.atmPin = 2222;
        welcome();
    }
    
    public void welcome() {
        System.out.println("ATM [accountNo=" + accountNo + ", amount=" + amount + ", atmPin=" + atmPin + "]");
    }
    
    public int getAccountNo() {
        return accountNo;
    }
    
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getAtmPin() {
        return atmPin;
    }
    
    public void setAtmPin(int atmPin) {
        this.atmPin = atmPin;
    }
    
    public boolean isValidPin(int pin) {
        return pin == atmPin;
    }
    
    public boolean pinChange(int oldPin, int newPin, int confirmPin) {
        if (oldPin != atmPin) {
            System.out.println("Invalid pin entered");
            return false;
        }
        
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("Pin must be 4 digits");
            return false;
        }
        
        if (newPin != confirmPin) {
            System.out.println("Pin confirmation doesn't match");
            return false;
        }
        
        atmPin = newPin;
        System.out.println("Pin changed successfully");
        return true;
    }
    
    public String Deposit(int acno,int balance) {
    	
    	if(acno != getAccountNo()) {
    		
    		return "invalid account no";
    	}
    	
    	if(balance < 0) {
    		
    		return "invalid amount";
    	}
    	
    	amount = balance + amount;
    	
    	System.out.println(amount);
    	
    	
    	
    	return "amount credited successfully";
    }
    
    public static void main(String[] args) {
        Atm a = new Atm();
        
        Scanner sc = new Scanner(System.in);
        a.pinChange(2222, 1122, 1122);
        a.welcome();
        
        System.out.println("enter account no");
        int acno = sc.nextInt();
        
        System.out.println("enter amount");
        int balance = sc.nextInt();
        
        a.Deposit(acno, balance);
        
        a.welcome();
        
        
    }
}
