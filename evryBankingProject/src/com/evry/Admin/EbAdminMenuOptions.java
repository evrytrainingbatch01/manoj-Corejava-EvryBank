package com.evry.Admin;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.evry.AdminImp.EbadminOperations;
import com.evry.AdminImp.EbcustomerCRUDOperations;

public class EbAdminMenuOptions {
	int selectedNum=0;
	Scanner myObj = new Scanner(System.in);
	EbadminOperations crudObj=new EbcustomerCRUDOperations();
	//EbcustomerCRUDOperations subOPts=new EbcustomerCRUDOperations();
	public int  mainmenuOptions(int selectedValue) {
		
		switch (selectedValue) {
		case 1:
			System.out.println("--------------------------------------");
			System.out.println("----Customer Modification---");
			System.out.println("Enter Number for Operation:");
			System.out.println("--------------------------------------");
			System.out.println("1.Get All Cumstomer Details:");
			System.out.println("2.Add New Customer:");
			System.out.println("3.Update Exiting Customer:");
			System.out.println("4.Delete Exiting Customer:");
	    	selectedNum = myObj.nextInt();   
	  	    System.out.println("selected Number is: " + selectedNum);
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
					System.out.println(" Cumstomer Craeted Successfully");
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
			break;
		//default:
		//	break;
		}
		return 0;
		
	}

}
