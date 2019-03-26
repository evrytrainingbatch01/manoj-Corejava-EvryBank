package com.evry.CustomerImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.evry.Customer.EbRequestingLoan;
import com.evry.util.DataBaseConnection;

public class Eb_requestingLoanImpl   {
	DataBaseConnection connection= DataBaseConnection.getDbCon();
	Scanner myObj = new Scanner(System.in);


	EbRequestingLoan req=(int custId)->{
		
		int res=0;
		System.out.println("from customer Eb_requistingLoan method---");
		System.out.println("Enter How much Amount want to Request");
		int amount=myObj.nextInt();
		
		 try {
			res=connection.update("update account set acc_loan_Amount_req="+amount+",acc_loan=1  where acc_customerId="+custId+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
		
	};
	//req.Eb_requestingLoan(int custId);
}
