package com.evry.AdminImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.evry.util.DataBaseConnection;

public  class EbExtraOperations extends EbadminOperations{

	DataBaseConnection connection= DataBaseConnection.getDbCon();
	ResultSet result;
	Scanner myObj = new Scanner(System.in);
	@Override
	public int eb_addMoney() {
		// TODO Auto-generated method stub
		System.out.println("eb_addMoney");
		
		return 0;
	}

	@Override
	public int eb_approveTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Enter customer account number to approve Loans ");
		int custAccNum= myObj.nextInt();
		int res=0;
		System.out.println("eb_provideLoans");
		try {
			
		result=	connection.getQuery("select * from account where acc_account_num="+custAccNum+"");
			while(result.next()) {
				System.out.println(result.getInt("acc_loan"));
				if(result.getInt("acc_loan")==1) {
					 res=connection.update("update account set  acc_approval =1 where acc_account_num="+custAccNum+"");
				
					
				}else {
					System.out.println("customer did not ask loan");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}

	@Override
	public int eb_provideLoans() {
		// TODO Auto-generated method stub
		System.out.println("Enter customer account number to provide Loans ");
		int custAccNum= myObj.nextInt();
		int res=0;
		System.out.println("eb_provideLoans");
		try {
			
		result=	connection.getQuery("select * from account where acc_account_num="+custAccNum+"");
			while(result.next()) {
				System.out.println(result.getInt("acc_loan"));
				if(result.getInt("acc_loan")==1) {
					 res=connection.update("update account set  acc_approval =1 where acc_account_num="+custAccNum+" ");
				
					
				}else {
					System.out.println("customer did not ask loan");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}

}
