package com.evry.main;

import java.util.Map;
import java.util.Scanner;

import com.evry.Admin.EbAdminMenuOptions;
import com.evry.login.Eblogin;

public class EntryMenuOptions {
	public static void Menu() {
		EbAdminMenuOptions mainmenu= new EbAdminMenuOptions(); 
		String userName;
		String Password;
		boolean checkLogin;
		Scanner myObj = new Scanner(System.in);
		Scanner myObj1 = new Scanner(System.in);
		System.out.println("Please Enter Username :"); 
	    userName = myObj.nextLine();   
	  //  System.out.println("Username is: " + userName); 
		System.out.println("Please Enter Password :"); 
	    Password = myObj1.nextLine();   
	   // System.out.println("Password is: " + Password); 
	    
	    checkLogin= Eblogin.checkLoginCredentials(userName,Password);
	    if(checkLogin) {
	    	Map<String,Object> map=Eblogin.checkUserRole(userName,Password);
	    	if((boolean) map.get("AdminRole")) {
	    		
	    	int selectedNum=0;
	    	System.out.println("-----log in Successfully----");
				/*
				 * System.out.println("Enter number For Menu :");
				 * System.out.println("1 -> Customer modification ");
				 * System.out.println("2 ->  Extra"); System.out.println("3 -> Exit");
				 * selectedNum = myObj.nextInt(); System.out.println("selected Number is: " +
				 * selectedNum);
				 */
	  	int selectednumber=  mainmenu.mainmenuOptions();
	  	    
	    	}else {
		    	int selectedNum=0;
		    	System.out.println("-----log in Successfully----");
		    	System.out.println("Enter number 1 For Menu :");
		    	selectedNum = myObj.nextInt();  
		  	int selectednumber=  mainmenu.CustomerMenuOptions(selectedNum,map);
	    		
	    	}
	    	
	    }else {
	    	System.out.println("---Wrong Username or Password----");
	    }
	    
	}
}
