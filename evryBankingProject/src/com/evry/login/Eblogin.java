package com.evry.login;

public class Eblogin {

	static String name="manoj";
	static String password="manoj@123";
	public static boolean checkLoginCredentials(String uname, String pass) {
		
		System.out.println("uname "+uname);
		System.out.println("pass "+pass);
		if(name.equals(uname) || password.equals(pass)) {
			
			return true;
		}else {
			
			return false;
		}
	}
}
