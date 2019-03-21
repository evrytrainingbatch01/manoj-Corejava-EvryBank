package com.evry.main;

import java.util.Map;
import java.util.Scanner;

import com.evry.Admin.EbAdminMenuOptions;
import com.evry.login.Eblogin;

public class EntryEvryBank {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String userName;
		String Password;
		EbAdminMenuOptions mainmenu = new EbAdminMenuOptions();
		boolean checkLogin;
		System.out.println("Welcome to Evry India Bank ");
		System.out.println("Log In ");
		Scanner myObj = new Scanner(System.in);
		Scanner myObj1 = new Scanner(System.in);
		boolean Exit = true;
		while (Exit) {
			System.out.println("Enter number For Menu :");
			System.out.println("1 -> Admin LogIn ");
			System.out.println("2 -> Customer LogIn");
			System.out.println("3 -> Exit");
			int selectedValue = myObj.nextInt();
			System.out.println("selected Number is: " + selectedValue);
			switch (selectedValue) {
			case 1:
				EntryMenuOptions.Menu();
				break;
			case 2:
				EntryMenuOptions.Menu();
				break;
			case 3:
				Exit=false;
				break;
			}
		}
		/*
		 * System.out.println("Please Enter Username :"); userName = myObj.nextLine();
		 * // System.out.println("Username is: " + userName);
		 * System.out.println("Please Enter Password :"); Password = myObj1.nextLine();
		 * // System.out.println("Password is: " + Password);
		 * 
		 * checkLogin= Eblogin.checkLoginCredentials(userName,Password); if(checkLogin)
		 * { Map<String,Object> map=Eblogin.checkUserRole(userName,Password);
		 * if((boolean) map.get("AdminRole")) {
		 * 
		 * int selectedNum=0; System.out.println("-----log in Successfully----");
		 * 
		 * System.out.println("Enter number For Menu :");
		 * System.out.println("1 -> Customer modification ");
		 * System.out.println("2 ->  Extra"); System.out.println("3 -> Exit");
		 * selectedNum = myObj.nextInt(); System.out.println("selected Number is: " +
		 * selectedNum);
		 * 
		 * int selectednumber= mainmenu.mainmenuOptions();
		 * 
		 * }else { int selectedNum=0;
		 * System.out.println("-----log in Successfully----");
		 * System.out.println("Enter number 1 For Menu :"); selectedNum =
		 * myObj.nextInt(); int selectednumber=
		 * mainmenu.CustomerMenuOptions(selectedNum,map);
		 * 
		 * }
		 * 
		 * }else { System.out.println("---Wrong Username or Password----"); }
		 */

	}

}
