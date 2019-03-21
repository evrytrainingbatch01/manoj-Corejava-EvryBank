package com.evry.CustomerImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.evry.Customer.EbCustomerOperations;
import com.evry.util.DataBaseConnection;

public class EbCustomerOperationsImpl implements EbCustomerOperations {
	DataBaseConnection connection= DataBaseConnection.getDbCon();
	ResultSet result;
	Scanner myObj = new Scanner(System.in);
	@Override
	public List<Map<String, Object>> Eb_getAccountDetails(int custId) {
		
		List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
		  try {
			  result=connection.getQuery("select * from customer as cust join account as acc on cust.account_Num=acc.acc_account_Num  where cust.id="+custId+"");
		 // System.out.println("result-----"+result);
		  //result.absolute(3);
		  while (result.next()) {
			  Map<String,Object> tempmap= new HashMap<String,Object>();
			//  System.out.println("firstname-- "+result.getString("firstname"));
			  tempmap.put("Id",result.getInt("id"));
			  tempmap.put("Firstname",result.getString("firstname"));
			  tempmap.put("Lastname",result.getString("lastname"));
			  tempmap.put("Age",result.getInt("age"));
			  tempmap.put("City",result.getString("city"));
			  tempmap.put("Country",result.getString("country"));
			  tempmap.put("Mobile_num",result.getString("mobile_num"));
			  tempmap.put("Email_id",result.getString("email_id"));
			  tempmap.put("Password",result.getString("password"));
			  tempmap.put("Account_num",result.getInt("account_num"));
			  tempmap.put("Balance",result.getInt("balance"));
			list.add(tempmap);
		}
		 // System.out.println("customer List:- "+list);
		
		  
		  } 
		  catch (SQLException e) { 
			  e.printStackTrace();
			  // TODOAuto-generated catch block e.printStackTrace(); }
		  }
		 return list;
		
	}

	@Override
	public int Eb_addMoney(int custId) {
		int res=0;
		System.out.println("Enter Customer Amount to Credit Money");
		int Amount=	myObj.nextInt();
		int peviousBal=0;
		try {
			result=connection.getQuery("select balance from customer where id="+custId+"");
			while(result.next()) {
				  System.out.println("balanace-- "+result.getInt("balance"));
				  peviousBal=result.getInt("balance");
			
			}
			int newValuetoUpdate=(peviousBal+Amount);
			 int  res1=connection.update("update customer set balance="+newValuetoUpdate+" where id="+custId+"");
			  if(res1>0) {
				  res=connection.update("update account set balance="+newValuetoUpdate+" where acc_customerId="+custId+"");
			  }else {
				  res=0;
			  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}

	@Override
	public int Eb_sendMoney(int custId) {
		int res=0;
		System.out.println("Enter Customer Name to Trasform the Money :");
		String ToCustName=	myObj.nextLine();
		try {
			result=connection.getQuery("select * from customer where firstname="+ToCustName+"");
		while(result.next()) {
			  //System.out.println("balanace-- "+result.getInt("balanace"));
			  Map<String,Object> tempmap= new HashMap<String,Object>();
			 // System.out.println("firstname-- "+result.getString("firstname"));
			  tempmap.put("Id",result.getInt("id"));
			  tempmap.put("firstname",result.getInt("firstname"));
			  tempmap.put("balanace",result.getInt("balanace"));
			  
			  System.out.println("Enter Customer Amount to Credit Money :");
			  int Amount=	myObj.nextInt();
			  int TopeviousBal=(int) tempmap.get("balanace");
			  int ToCustId=(int) tempmap.get("Id");
			  try {
				  int newValuetoUpdate=(TopeviousBal+Amount);
				 int  res1=connection.update("update customer set balance="+newValuetoUpdate+" where id="+ToCustId+"");
				  if(res1>0) {
					  res=connection.update("update account set balance="+newValuetoUpdate+" where acc_customerId="+ToCustId+"");
				  }else {
					  res=0;
				  }
				 
			  } catch (SQLException e) {
				  res=0;
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
		
		}
		} catch (SQLException e1) {
			res=0;
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
		
	}

	@Override
	public int Eb_withDrawMoney(int custId) {
		int res=0;
		System.out.println("Enter Customer Amount to withDraw Money");
		int Amount=	myObj.nextInt();
		int peviousBal=0;
		try {
			result=connection.getQuery("select balance from customer where id="+custId+"");
			while(result.next()) {
				  System.out.println("balanace-- "+result.getInt("balance"));
				  peviousBal=result.getInt("balance");
			
			}
			int newValuetoUpdate=(peviousBal-Amount);
			 int  res1=connection.update("update customer set balance="+newValuetoUpdate+" where id="+custId+"");
			  if(res1>0) {
				  res=connection.update("update account set balance="+newValuetoUpdate+" where acc_customerId="+custId+"");
			  }else {
				  res=0;
			  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}

	@Override
	public int Eb_requistingLoan(int custId) {
		
		
		return 0;
		
	}


	

}
