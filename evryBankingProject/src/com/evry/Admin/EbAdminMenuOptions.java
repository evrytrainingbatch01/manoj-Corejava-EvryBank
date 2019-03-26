package com.evry.Admin;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.evry.AdminImp.EbExtraOperations;
import com.evry.AdminImp.EbadminOperations;
import com.evry.AdminImp.EbcustomerCRUDOperations;
import com.evry.Customer.EbCustomerOperations;
import com.evry.CustomerImp.EbCustomerOperationsImpl;

public class EbAdminMenuOptions {
	int selectedNum=0;
	Scanner myObj = new Scanner(System.in);
	EbadminOperations crudObj=new EbcustomerCRUDOperations();
	EbadminOperations exrtObj=new EbExtraOperations();
	//EbcustomerCRUDOperations subOPts=new EbcustomerCRUDOperations();
	public int  CustomerMenuOptions(int selectedValue,Map<String,Object> custDetails) {
		EbCustomerOperations cust=new EbCustomerOperationsImpl();
		//System.out.println("custDetails--- "+custDetails);
		int custId=(int) custDetails.get("Id");
		String name=(String) custDetails.get("name");
		switch (selectedValue) {
		case 1:
			boolean logout=true;
			while(logout) {
			System.out.println("--------------------------------------");
			System.out.println("----Customer Transaction---");
			System.out.println("Enter Number for Transaction:");
			System.out.println("--------------------------------------");
			System.out.println("1 -> Get Your Details:");
			System.out.println("2 -> Credit Money:");
			System.out.println("3 -> With Draw Money:");
			System.out.println("4 -> Send Money:");
			System.out.println("5 -> Requisting Loan:");
			System.out.println("6 -> Logout:");
	    	selectedNum = myObj.nextInt();   
	  	    //System.out.println("selected Number is: " + selectedNum);
	  	    switch (selectedNum) {
			case 1:
				List<Map<String,Object>> list=cust.Eb_getAccountDetails(custId);
				System.out.println("-------------------------------------------------------------------");
				System.out.println(" .........................Hi "+name+" Your Details.................");
				System.out.println("-------------------------------------------------------------------");
				  for (Map<String, Object> map : list) {
						//System.out.println("-------------------------------------------------------------------");
						//System.out.println(map);
						System.out.println("-------------Profile Details--------------");
						System.out.println(" First Name    : "+map.get("Firstname"));
						System.out.println(" Last Name     : "+map.get("Lastname"));
						System.out.println(" Mobile Number : "+map.get("Mobile_num"));
						System.out.println(" EmailId       : "+map.get("Email_id"));
						System.out.println(" Age           : "+map.get("Age"));
						System.out.println(" City          : "+map.get("City"));
						System.out.println(" Country       : "+map.get("Country"));
						System.out.println("");
						System.out.println("-------------Account Details----------------");
						System.out.println(" Account Number		: "+map.get("Account_num"));
						System.out.println(" Balanace		: "+map.get("Balance"));

						System.out.println("-------------------------------------------------------------------");
					}
				break;
			case 2:
				int res=cust.Eb_addMoney(custId);
				if(res>0) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println(" Amount Successfully Credited ");
					System.out.println("-------------------------------------------------------------------");
				}else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("some thing is Wrong, Please Try Again");
					System.out.println("-------------------------------------------------------------------");
				}
				break;
			case 3:
				int res1=cust.Eb_withDrawMoney(custId);
				if(res1>0) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println(" Amount Successfully Dedited");
					System.out.println("-------------------------------------------------------------------");
				}else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("some thing is Wrong, Please Try Again");
					System.out.println("-------------------------------------------------------------------");
				}
				break;
			case 4:
				int res2=cust.Eb_sendMoney(custId);
				//System.out.println("res2- "+res2);
				if(res2>0) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println(" Amount Successfully Sent");
					System.out.println("-------------------------------------------------------------------");
				}else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("some thing is Wrong, Please Try Again");
					System.out.println("-------------------------------------------------------------------");
				}
				//flag=false;
			case 5:
				int res3=cust.Eb_requistingLoan(custId);
				if(res3>0) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println(" Amount Requested  Successfully ");
					System.out.println("-------------------------------------------------------------------");
				}else {
					logout=false;
					System.out.println("-------------------------------------------------------------------");
					System.out.println("some thing is Wrong, Please Try Again");
					System.out.println("-------------------------------------------------------------------");
				}
			case 6:
				logout=false;

			}
				/*
				 * if(selectedNum==1) { List<Map<String,Object>>
				 * list=cust.Eb_getAccountDetails(custId); System.out.println(
				 * "-------------------------------------------------------------------");
				 * System.out.println(" .........................Hi "
				 * +name+" Your Details................."); System.out.println(
				 * "-------------------------------------------------------------------"); for
				 * (Map<String, Object> map : list) { //System.out.println(
				 * "-------------------------------------------------------------------");
				 * //System.out.println(map);
				 * System.out.println("-------------Profile Details--------------");
				 * System.out.println(" First Name    : "+map.get("Firstname"));
				 * System.out.println(" Last Name     : "+map.get("Lastname"));
				 * System.out.println(" Mobile Number : "+map.get("Mobile_num"));
				 * System.out.println(" EmailId       : "+map.get("Email_id"));
				 * System.out.println(" Age           : "+map.get("Age"));
				 * System.out.println(" City          : "+map.get("City"));
				 * System.out.println(" Country       : "+map.get("Country"));
				 * System.out.println("");
				 * System.out.println("-------------Account Details----------------");
				 * System.out.println(" Account Number		: "+map.get("Account_num"));
				 * System.out.println(" Balanace		: "+map.get("Balance"));
				 * 
				 * System.out.println(
				 * "-------------------------------------------------------------------"); }
				 * }else if(selectedNum==2) { int res=cust.Eb_addMoney(custId); if(res>0) {
				 * System.out.println(
				 * "-------------------------------------------------------------------");
				 * System.out.println(" Amount Successfully Credited "); System.out.println(
				 * "-------------------------------------------------------------------"); }else
				 * { System.out.println(
				 * "-------------------------------------------------------------------");
				 * System.out.println("some thing is Wrong, Please Try Again");
				 * System.out.println(
				 * "-------------------------------------------------------------------"); } }
				 * else if(selectedNum==3) { int res=cust.Eb_withDrawMoney(custId); if(res>0) {
				 * System.out.println(
				 * "-------------------------------------------------------------------");
				 * System.out.println(" Amount Successfully Dedited"); System.out.println(
				 * "-------------------------------------------------------------------"); }else
				 * { System.out.println(
				 * "-------------------------------------------------------------------");
				 * System.out.println("some thing is Wrong, Please Try Again");
				 * System.out.println(
				 * "-------------------------------------------------------------------"); } }
				 */

			}
			break;
		case 2:
			System.out.println("----Extra---");
			break;
		//default:
		//	break;
		}
			
		return 0;
		
	}

	
	public int  mainmenuOptions() {
    	System.out.println("Enter number For Menu :");
    	System.out.println("1 -> Customer modification ");
    	System.out.println("2 ->  Extra");
    	System.out.println("3 -> LogOut");
    	int selectedValue = myObj.nextInt();   
    	
  	    boolean flag=true;
  	    while(flag) {
		switch (selectedValue) {
		case 1:
			System.out.println("--------------------------------------");
			System.out.println("----Customer Modification---");
			System.out.println("Enter Number for Operation:");
			System.out.println("--------------------------------------");
			System.out.println("1 -> Get All Cumstomer Details:");
			System.out.println("2 -> Add New Customer:");
			System.out.println("3 -> Update Exiting Customer:");
			System.out.println("4 -> Delete Exiting Customer:");
	    	selectedNum = myObj.nextInt();   
			if(selectedNum==1) {
				List<Map<String,Object>> list=crudObj.eb_getAllCustomers();
				System.out.println("-------------------------------------------------------------------");
				System.out.println(" .........................Cumstomer List...........................");
				System.out.println("-------------------------------------------------------------------");
				for (Map<String, Object> map : list) {
					System.out.println("-------------------------------------------------------------------");
					//System.out.println(map);
					System.out.println(" First Name    : "+map.get("Firstname"));
					System.out.println(" Last Name     : "+map.get("Lastname"));
					System.out.println(" Mobile Number : "+map.get("Mobile_num"));
					System.out.println(" EmailId       : "+map.get("Email_id"));
					System.out.println(" Age           : "+map.get("Age"));
					System.out.println(" City          : "+map.get("City"));
					System.out.println(" Country       : "+map.get("Country"));
				
					System.out.println("-------------------------------------------------------------------");
				}

			}else if(selectedNum==2) {
				int res=crudObj.eb_addNewCustomer();
				if(res>0) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println(" Cumstomer Created Successfully");
					System.out.println("-------------------------------------------------------------------");
				}else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("some thing is Wrong, Please Try Again");
					System.out.println("-------------------------------------------------------------------");
				}
			}
			else if(selectedNum==3) {
				int res=crudObj.eb_updateCustomer();
				if(res>0) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("Cumstomer Updated Successfully");
					System.out.println("-------------------------------------------------------------------");
				}else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("some thing is Wrong, Please Try Again");
					System.out.println("-------------------------------------------------------------------");
				}
			}
			else if(selectedNum==4) {
				int res=crudObj.eb_deleteCustomer();
				if(res>0) {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("Cumstomer Deleted Successfully");
					System.out.println("-------------------------------------------------------------------");
					crudObj.eb_getAllCustomers();
				}else {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("some thing is Wrong, Please Try Again");
					System.out.println("-------------------------------------------------------------------");
					crudObj.eb_getAllCustomers();
				}
			}
			
			break;
		case 2:
			System.out.println("----Extra---");
			boolean back=true;
			while(back) {
				System.out.println("1 -> Approve the Loan");
				//System.out.println("2 -> Provide the Loan");
				System.out.println("3 -> Exit");
				int selectednum=myObj.nextInt();
				switch (selectednum) {
				case 1:
					int res=exrtObj.eb_approveTransaction();
					if(res>0) {
						System.out.println("-------------------------------------------------------------------");
						System.out.println("Loan  Successfully approved");
						System.out.println("-------------------------------------------------------------------");
						crudObj.eb_getAllCustomers();
					}else {
						System.out.println("-------------------------------------------------------------------");
						System.out.println("some thing is Wrong, Please Try Again");
						System.out.println("-------------------------------------------------------------------");
						crudObj.eb_getAllCustomers();
					}
					break;
				case 2:
					int res2=exrtObj.eb_provideLoans();
					if(res2>0) {
						System.out.println("-------------------------------------------------------------------");
						System.out.println("Loan  Successfully provided");
						System.out.println("-------------------------------------------------------------------");
						crudObj.eb_getAllCustomers();
					}else {
						System.out.println("-------------------------------------------------------------------");
						System.out.println("some thing is Wrong, Please Try Again");
						System.out.println("-------------------------------------------------------------------");
						crudObj.eb_getAllCustomers();
					}
					break;
				case 3:
					back=false;
					flag=false;
					
					break;
				
				}
			}

			break;
		case 3:
			flag=false;
			//System.out.println("----Extra---");
			break;
		//default:
		//	break;
			
		}
}
		return 0;
		
	}
}
