package com.bank.pentagon;

import java.sql.*;
import java.util.Scanner;

public class CustomerInterface 
{
     public static void showDetails()
     {
    	 int choice=0;
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Welcome to pentagon Bank");
    	 System.out.println("Select the Option");
    	 System.out.println("1. Check Accout Balance");
    	 System.out.println("2. Deposit");
    	 System.out.println("3. Withdraw");
    	 System.out.println("4. Transfer the Amount");
    	 System.out.println("5. Create the PIN");
    	 System.out.println("6. Go back to MainMenu");
    	 System.out.println("Enter Your Option");
    	 choice=sc.nextInt();
    	 switch(choice)
    	 {
    	 case 1:
    		 checkBalance();
    		 break;
    	 case 2:
    		 deposit();
    		 break;
    	 case 3:
    		 withdraw();
    		 break;
    	 case 4:
    		 transfer();
    		 break;
    	 case 5:
    		 generatePIN();
    		 break;
    	 case 6:
    		 System.out.println("Returning to main Menu");
    		 System.exit(0);
    	default:
    		System.out.println("You Are Enter The Invalid Choice");
    	 }
    	 
     }
     private static void generatePIN() 
     {
    	 Connection con=null;
  	   PreparedStatement ps=null;
  	   Scanner sc=new Scanner(System.in);
  	   String pin="UPDATE PENTAGON SET PIN=? WHERE ACCNO=?";
  	   try {
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"
  				           +"user=root&password=tiger");
  		ps=con.prepareStatement(pin);
  		System.out.println("Enter the Account Number: ");
  		int acc=sc.nextInt();
  		ps.setInt(2, acc);
  		System.out.println("Enter the 4 Digit to be set: ");
  		int pin1=sc.nextInt();
  		if(pin1>999&&pin1<10000) {
  		ps.setDouble(1, pin1);
  		}
  		else
  		{
  			System.out.println("You areEntered the Invalid Pin");
  		}
  		ps.executeUpdate();
  		System.out.println("Your Pin Generation Has Successfully Completed..!");
  	} 
  	   catch (ClassNotFoundException | SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	   finally
  		{
  			if(ps!=null) {
     			try {
  					ps.close();
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
	private static void transfer()
     {
       Connection con=null;
  	   PreparedStatement ps1=null,ps2=null;
  	   Scanner sc=new Scanner(System.in);
  	   String debit="UPDATE PENTAGON SET BALANCE=BALANCE-? WHERE ACCNO=?";
  	   String credit="UPDATE PENTAGON SET BALANCE=BALANCE+? WHERE ACCNO=?";
  	 try {
 		Class.forName("com.mysql.cj.jdbc.Driver");
 		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"
 				           +"user=root&password=tiger");
 		System.out.println("Enter the Benificiary Account Number: ");
 		int acc2=sc.nextInt();
 		System.out.println("Enter the Amount To be Transfered: ");
 		double amt=sc.nextDouble();
 		System.out.println("Enter the Your Account Number: ");
 		int acc1=sc.nextInt();
 		ps1=con.prepareStatement(debit);
 		ps1.setInt(2,acc1);
 		ps1.setDouble(1, amt);
 		ps1.executeUpdate();
 		ps2=con.prepareStatement(credit);
 		ps2.setInt(2,acc2);
 		ps2.setDouble(1, amt);
 		ps2.executeUpdate();
 		System.out.println("The Amount of Rs "+amt+" is successfully Transferred to"+acc2);
 	} 
 	   catch (ClassNotFoundException | SQLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
  	 finally
		{
  		if(ps2!=null) {
			try {
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps1!=null) {
			try {
					ps1.close();
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
	private static void withdraw()
     {
	   Connection con=null;
	   PreparedStatement ps=null;
	   Scanner sc=new Scanner(System.in);
	   String whd="UPDATE PENTAGON SET BALANCE=BALANCE-? WHERE ACCNO=?";
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"
				           +"user=root&password=tiger");
		ps=con.prepareStatement(whd);
		System.out.println("Enter the Account Number: ");
		int acc=sc.nextInt();
		ps.setInt(2, acc);
		System.out.println("Enter the Amount To be Deposited: ");
		double amt=sc.nextDouble();
		ps.setDouble(1, amt);
		ps.executeUpdate();
		System.out.println("Amount of RS: "+amt+"has been deposited to your account Successfully..!");
	} 
	   catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   finally
		{
			if(ps!=null) {
   			try {
					ps.close();
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
			
		}
		
		
	}
	private static void deposit() 
     {
    	 Connection con=null;
    	 PreparedStatement ps=null;
    	 Scanner sc=new Scanner(System.in);
    	 String dep="UPDATE PENTAGON SET BALANCE=BALANCE+? WHERE ACCNO=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"
					                           +"user=root&password=tiger");
			ps=con.prepareStatement(dep);
			System.out.println("Enter the Account Number: ");
			int acc=sc.nextInt();
			ps.setInt(2, acc);
			System.out.println("Enter the Amount To be Deposited: ");
			double amt=sc.nextDouble();
			ps.setDouble(1, amt);
			ps.executeUpdate();
			System.out.println("Amount of RS: "+amt+" has been Deposited to your account ..!");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null) {
    			try {
					ps.close();
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
			
		}
		
	}
	private static void checkBalance() 
     {
    	 Connection con=null;
    	 PreparedStatement ps=null;
    	 Scanner sc =new Scanner(System.in);
    	 String bal="SELECT * FROM PENTAGON WHERE ACCNO=?";
    	 ResultSet rs=null;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"
					+"user=root&password=tiger");
			ps=con.prepareStatement(bal);
			System.out.println("Enter the Account Number");
			int acc=sc.nextInt();
			ps.setInt(1, acc);
			rs=ps.executeQuery();
			if(rs.next())
			{
			    Double balance= rs.getDouble(4);
			    String name=rs.getString(2);
				System.out.println("Dear " +name+ "Your balance is Rs:"+balance);	
			}
			else {
				System.out.println("Invalid Details are Entered");
			}
			
			
		} 
    	catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		if(rs!=null) {
    			try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		if(ps!=null) {
    			try {
					ps.close();
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
