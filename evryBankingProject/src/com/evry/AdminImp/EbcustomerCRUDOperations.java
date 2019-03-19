package com.evry.AdminImp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.evry.util.DataBaseConnection;

public class EbcustomerCRUDOperations extends EbadminOperations{
	
	DataBaseConnection connection= DataBaseConnection.getDbCon();
	ResultSet result;
	@Override
	public int eb_getAllCustomers() {
		// TODO Auto-generated method stub
		System.out.println("-----------------eb_getAllCustomers method-------------------------------");
		/*
		 * try { result=connection.getQuery("select * from customer");
		 * System.out.println("result-----"+result); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		return 0;
		
	}

	@Override
	public int eb_addNewCustomer() {
		return 0;
		// TODO Auto-generated method stub
		//System.out.println("eb_addNewCustomer method");
		
	}

	@Override
	public int eb_updateCustomer() {
		return 0;
		// TODO Auto-generated method stub
		//System.out.println("eb_updateCustomer method");
		
	}

	@Override
	public int eb_deleteCustomer() {
		return 0;
		// TODO Auto-generated method stub
		//System.out.println("eb_deleteCustomer method");
		
	}
}
