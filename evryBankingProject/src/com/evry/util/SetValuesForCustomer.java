package com.evry.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SetValuesForCustomer {

	static Scanner myObj = new Scanner(System.in);
	static CustomerPOJO cpojo=new CustomerPOJO();
	public static Map<String ,Object> setValues() {
		System.out.println("------------------------------------------------------");
		System.out.println("please Enter the New Customer Details");
		System.out.println("------------------------------------------------------");
		
		System.out.println("Enter First Name :");
		String firstName = myObj.nextLine(); 
		cpojo.setCustomerFirstName(firstName);
		
		System.out.println("Enter Last Name :");
		String lastName = myObj.nextLine(); 
		cpojo.setCustomerLastName(lastName);
		
		System.out.println("Enter Password :");
		String password = myObj.nextLine(); 
		cpojo.setCustomerPassword(password);
		
		System.out.println("Enter Mobile Number :");
		String mobileNum = myObj.nextLine(); 
		cpojo.setCustomerMobileNum(mobileNum);
		
		System.out.println("Enter EmailId :");
		String emailId = myObj.nextLine(); 
		cpojo.setCustomerEmailId(emailId);
		
		System.out.println("Enter Age :");
		int age = myObj.nextInt(); 
		cpojo.setCustomerAge(age);
		
		System.out.println("Enter City and ");
		String city = myObj.nextLine(); 
		cpojo.setCustomerCity(city);
		
		System.out.println("Enter Country :");
		String country = myObj.nextLine(); 
		cpojo.setCustomerCountry(country);
		
		System.out.println("Enter User Type 1-Admin, 2-Customer :");
		int usertype = myObj.nextInt(); 
		cpojo.setCustomerAge(usertype);
		
		System.out.println("Enter Balance :");
		int balance = myObj.nextInt(); 
		cpojo.setCustomerAge(balance);
		
		Random ra=new Random();
		ra.nextInt(10000000);
		//-------------------------------------------------------------
		Map<String ,Object> map =new HashMap<String ,Object>();
		map.put("firstName",firstName);
		map.put("lastName",lastName);
		map.put("password",password);
		map.put("mobileNum",mobileNum);
		map.put("emailId",emailId);
		map.put("age",age);
		map.put("city",city);
		map.put("country",country);
		map.put("usertype",usertype);
		map.put("balance",balance);
		map.put("account_num",ra.nextInt(10000000));
		return map;
	}
	
	
}
