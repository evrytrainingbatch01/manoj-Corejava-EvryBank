package com.evry.main;

import java.util.Scanner;

import com.evry.Admin.EbAdminMenuOptions;
import com.evry.login.Eblogin;

public class EntryEvryBank {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String userName;
		String Password;
		EbAdminMenuOptions mainmenu= new EbAdminMenuOptions(); 
		boolean checkLogin;
		System.out.println("Welcome to Evry India Bank ");
		System.out.println("Log In ");
		Scanner myObj = new Scanner(System.in);
		Scanner myObj1 = new Scanner(System.in);
		System.out.println("Enter Username :"); 
		
	    userName = myObj.nextLine();   
	    System.out.println("Username is: " + userName); 
		System.out.println("Enter Password :"); 
	    Password = myObj1.nextLine();   
	    System.out.println("Password is: " + Password); 
	    
	    checkLogin= Eblogin.checkLoginCredentials(userName,Password);
	    if(checkLogin) {
	    	int selectedNum=0;
	    	System.out.println("					-----log in Successfully----                           ");
	    	System.out.println("Enter number For Menu :");
	    	System.out.println("1. Customer modification ");
	    	System.out.println("2.  Extra");
	    	selectedNum = myObj.nextInt();   
	  	    System.out.println("selected Number is: " + selectedNum); 
	  	int selectednumber=  mainmenu.mainmenuOptions(selectedNum);
	  	    
	    	
	    }else {
	    	System.out.println("---Wrong Username or Password----");
	    }
	    

	}

}
