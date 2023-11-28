package com.bank.pentagon;

import java.sql.*;
import java.util.Scanner;

public class EmployeeInterface 
{
 public static void addCustomerData() {
	 Connection con=null;
	 PreparedStatement ps=null;
	 String qry1="INSERT INTO PENTAGON (ACCNO,NAME,PHONENO)"
			 +"VALUES(?,?,?)";
	 Scanner sc= new Scanner(System.in);
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"
				+"user=root&password=tiger");
		System.out.println("<---Employee Interface");
		System.out.println("Welcome to Pentagon Bank");
		System.out.println("Please provide the Details of New Customer");
		ps=con.prepareStatement(qry1);
        System.out.println("Enter the Account Number: ");
        int acc=sc.nextInt();
        ps.setInt(1, acc);
        System.out.println("Enter the Customer Name: ");
        String nm=sc.next();
        ps.setString(2, nm);
        System.out.println("Enter the Phone Number: ");
       long phn=sc.nextLong();
        ps.setLong(3, phn);
        ps.executeUpdate();
        System.out.println("Values got added Successful");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//CLOSING COSTLY RESOURES
	finally {
		if(ps!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    if(con!=null) {
	    	try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    sc.close();
	}
}
}
