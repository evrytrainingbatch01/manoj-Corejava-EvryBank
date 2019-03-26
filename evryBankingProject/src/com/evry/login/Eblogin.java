package com.evry.login;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.evry.util.DataBaseConnection;

public class Eblogin {

	static DataBaseConnection connection= DataBaseConnection.getDbCon();
	static ResultSet result;
	Scanner myObj = new Scanner(System.in);
//	static String name="manoj";
//	static String password="manoj@123";
	public static boolean checkLoginCredentials(String uname, String pass) {
		boolean response=true;
		Map<String,Object> tempmap= new HashMap<String,Object>();
	
		  try {
			  result=connection.getQuery("select * from customer   where firstname='"+uname+"' and password='"+pass+"'");
		  while (result.next()) {
			  tempmap.put("Id",result.getInt("id"));
			  tempmap.put("name",result.getString("firstname"));
			  tempmap.put("password",result.getString("password"));
		}
		  if(tempmap.get("name").equals(uname) && tempmap.get("password").equals(pass)) {
			  response= true;
			}else {
				response= false;
			}
		
	}catch (Exception e) {
		response= false;
	}
		 
		return response;
	}
	public static Map<String,Object> checkUserRole(String uname, String pass) {
		Map<String,Object> tempmap= new HashMap<String,Object>();
		  try {
			  result=connection.getQuery("select * from customer where firstname='"+uname+"' and password='"+pass+"'");
		  while (result.next()) {
			  tempmap.put("Id",result.getInt("id"));
			  tempmap.put("name",result.getString("firstname"));
			  tempmap.put("password",result.getString("password"));
			  tempmap.put("userType",result.getString("acc_userType"));
		}
		int role= Integer.parseInt( tempmap.get("userType").toString()) ;
		  if(role==1) {
			tempmap.put("AdminRole",true);
			}else {
			tempmap.put("AdminRole",false);
			}
		
	}catch (Exception e) {
		return tempmap;
	}
		 
		return tempmap;
	}
}
