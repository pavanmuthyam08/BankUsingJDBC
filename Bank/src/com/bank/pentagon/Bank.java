package com.bank.pentagon;

import java.util.Scanner;

public class Bank
{
 public static void main(String[] args) 
 {
	int choice = 0;
	Scanner sc =new Scanner(System.in);
 
	while(choice!=3) {
		System.out.println("Welcome To Pentagon Bank");
		System.out.println("Select The Option");
	    System.out.println("1. Employee InterFace");
	    System.out.println("2. Customer Interface");
	    System.out.println("3. Exit");
	    System.out.println("Enter your option");
	    choice=sc.nextInt();
	
	    switch(choice) 
	    {
	    case 1:
	    	EmployeeInterface.addCustomerData();
	    	break;
	    case 2:
	    	CustomerInterface.showDetails();
	        break;
	    case 3:
	    	System.out.println("Exiting the Application, Thank You!!!");
	    	break;
	    default:
	    	System.out.println("Invalid Details Entered");
	    	 
	    }
	}
}
}
