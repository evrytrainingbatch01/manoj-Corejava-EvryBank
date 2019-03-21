package com.evry.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SetValuesForCustomer {

	static Scanner myObj = new Scanner(System.in);
	static CustomerPOJO cpojo=new CustomerPOJO();
	public static Map<String ,Object> setValues() {
		System.out.println("------------------------------------------------------");
		System.out.println("please Enter the New Customer Details");
		System.out.println("------------------------------------------------------");
		
		System.out.println("Enetr First Name :");
		String firstName = myObj.nextLine(); 
		cpojo.setCustomerFirstName(firstName);
		System.out.println("Enetr Last Name :");
		String lastName = myObj.nextLine(); 
		cpojo.setCustomerFirstName(lastName);
		System.out.println("Enetr Password :");
		String password = myObj.nextLine(); 
		cpojo.setCustomerFirstName(password);
		System.out.println("Enetr Mobile Number :");
		String mobileNum = myObj.nextLine(); 
		cpojo.setCustomerFirstName(mobileNum);
		System.out.println("Enetr EmailId :");
		String emailId = myObj.nextLine(); 
		cpojo.setCustomerFirstName(emailId);
		System.out.println("Enetr Age :");
		int age = myObj.nextInt(); 
		cpojo.setCustomerAge(age);
		System.out.println("Enetr City:");
		String city = myObj.nextLine(); 
		cpojo.setCustomerFirstName(city);
		System.out.println("Enetr Country :");
		String country = myObj.nextLine(); 
		cpojo.setCustomerFirstName(country);
		
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
		return map;
	}
	
	
}
