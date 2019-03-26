package com.evry.AdminImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.evry.util.CustomerPOJO;
import com.evry.util.DataBaseConnection;
import com.evry.util.SetValuesForCustomer;

public class EbcustomerCRUDOperations extends EbadminOperations{
	
	DataBaseConnection connection= DataBaseConnection.getDbCon();
	ResultSet result;
	Scanner myObj = new Scanner(System.in);
	@Override
	public List<Map<String,Object>> eb_getAllCustomers() {
		
		List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
		  try {
			  result=connection.getQuery("select * from customer");
		  while (result.next()) {
			  Map<String,Object> tempmap= new HashMap<String,Object>();
			 // System.out.println("Name-- "+result.getString("firstname"));
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
		  //System.out.println("customer List:- "+list);
		  
		  } 
		  catch (SQLException e) { 
			  e.printStackTrace();
			  // TODOAuto-generated catch block e.printStackTrace(); }
		  }
		 
		return list;
		
	}

	@Override
	public int eb_addNewCustomer() {
		int res=0;
		Map<String,Object> returnmap= SetValuesForCustomer.setValues();
		//CustomerPOJO cpojo=new CustomerPOJO();
		System.out.println("Name---"+returnmap.get("firstName"));
		
		  try {
		  
		  res=connection.insert("insert into customer (firstname,lastname,age,city,country,mobile_num,email_id,balance,acc_userType,account_num,password)"
		  +
		  " values('"+returnmap.get("firstName")+"',"
		  		+ "'"+returnmap.get("lastName")+"',"
		  		+ ""+returnmap.get("age")+","
		  		+ "'"+returnmap.get("city")+"',"
		  		+ "'"+returnmap.get("country")+"',"
		  		+ "'"+returnmap.get("mobileNum")+"',"
		  		+ "'"+returnmap.get("emailId")+"',"
		  		+ ""+returnmap.get("balance")+","
		  		+ ""+returnmap.get("usertype")+","
		  		+ ""+returnmap.get("account_num")+","
		  		+ "'"+returnmap.get("password")+"');"
		  );
		  int acc_id=0;
		  if(res>0) {
			  String qry="select * from account where acc_id= (select max(acc_id) from account order by acc_id desc)";
			  ResultSet result1= connection.getQuery(qry);
			  while (result1.next()) {
				  acc_id= result1.getInt("acc_id");
				
			}
			  System.out.println(acc_id);
			 int res1=connection.insert("insert into account (acc_account_num,acc_customerId,acc_balance,acc_loan,acc_approval,acc_userType)"
					  + " values('"+returnmap.get("account_num")+"',"
					  		+ ""+acc_id+","
					  		+ ""+returnmap.get("balance")+",0,0,"
					  		+ ""+returnmap.get("usertype")+""
					  		+ ");"
					  );
		  }else {
			  
		  }
		  
		  } catch (SQLException e) {
			  // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  }
		
		return res;
	}

	@Override
	public int eb_updateCustomer() {
		System.out.println("Enter Customer Id:");
		int custId=myObj.nextInt();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Enter Number which one you want update :  ");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("1. For Customer FirstName");
		System.out.println("2. For Customer LastName");
		System.out.println("3. For Customer Age");
		System.out.println("4. For Customer City");
		System.out.println("5. For Customer Country");
		System.out.println("6. For Customer Mobile Number");
		System.out.println("7. For Customer  Email Id");
		System.out.println("8. For Customer  Password");
		int options=myObj.nextInt();
		System.out.println("your selected Number is "+options);
		int res=0;
		try {
			switch (options) {
			case 1:
				System.out.println(" Enter Customer FirstName: ");
				String firstname=	myObj.next();
				res=connection.update("update customer set firstname='"+firstname+"' where id="+custId+"");
				break;
			case 2:
				System.out.println(" Enter Customer LastName");
				String lastname=	myObj.next();
				res=connection.update("update customer set lastname='"+lastname+"' where id="+custId+"");
				break;
			case 3:
				System.out.println("Enter Customer Age");
				int age= myObj.nextInt();
				res=connection.update("update customer set age="+age+" where id="+custId+"");
				break;
			case 4:
				System.out.println("Enter Customer City");
				String city=	myObj.next();
				res=connection.update("update customer set city='"+city+"' where id="+custId+"");
				break;
			case 5:
				System.out.println("Enter Customer Country");
				String country=	myObj.next();
				res=connection.update("update customer set country='"+country+"' where id="+custId+"");
				break;
			case 6:
				System.out.println("Enter Customer Mobile Number");
				String mobile_num=	myObj.next();
				res=connection.update("update customer set mobile_num='"+mobile_num+"'  where id="+custId+"");
				break;
			case 7:
				System.out.println("Enter Customer  Email Id");
				
				String email_id=	myObj.next();
				res=connection.update("update customer set email_id='"+email_id+"' where id="+custId+"");
				break;
			case 8:
				System.out.println("Enter Customer  Password");
				String password=	myObj.next();
				res=connection.update("update customer set password='"+password+"' where id="+custId+"");
				break;


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		// TODO Auto-generated method stub
		//System.out.println("eb_updateCustomer method");
		
	}

	@Override
	public int eb_deleteCustomer() {
		System.out.println("Enter Customer Id For Delete :");
		int custId=myObj.nextInt();
		int res=0;
		try {
			res=connection.delete("Delete from customer  where id="+custId+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		// TODO Auto-generated method stub
		//System.out.println("eb_deleteCustomer method");
		
	}
}
