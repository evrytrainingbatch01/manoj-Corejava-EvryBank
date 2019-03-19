package com.evry.Admin;

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
			System.out.println("----Customer Modification---");
			System.out.println("Enter Number for Operation:");
			System.out.println("--------------------------------------");
			System.out.println("1.Get All Cumstomer Details:");
			System.out.println("2.Add New Customer:");
			System.out.println("3.Update Exiting Customer:");
			System.out.println("4.Delete Exiting Customer:");
			System.out.println("--------------------------------------");
	    	selectedNum = myObj.nextInt();   
	  	    System.out.println("selected Number is: " + selectedNum);
			if(selectedNum==1) {
				crudObj.eb_getAllCustomers();
			}else if(selectedNum==2) {
				crudObj.eb_addNewCustomer();
			}
			else if(selectedNum==3) {
				crudObj.eb_updateCustomer();
			}
			else if(selectedNum==4) {
				crudObj.eb_deleteCustomer();
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
