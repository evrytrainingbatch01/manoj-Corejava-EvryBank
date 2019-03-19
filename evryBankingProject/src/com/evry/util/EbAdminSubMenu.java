package com.evry.util;

import com.evry.AdminImp.EbadminOperations;
import com.evry.AdminImp.EbcustomerCRUDOperations;

public class EbAdminSubMenu {

	EbadminOperations crudObj=new EbcustomerCRUDOperations();
	public Object selectSubMenu(int num) {
		int selectedNum=0;
		switch (num) {
		case 1:
			System.out.println("eb_getAllCustomers method");
			selectedNum=crudObj.eb_getAllCustomers();
			
			break;
		case 2:
			System.out.println("eb_addNewCustomer method");
			selectedNum=crudObj.eb_addNewCustomer();
			break;
		case 3:
			System.out.println("eb_updateCustomer method");
			selectedNum=crudObj.eb_updateCustomer();
			break;
		case 4:
			System.out.println("eb_deleteCustomer method");
			selectedNum=crudObj.eb_deleteCustomer();
			break;


		}
		
		return selectedNum;
	}
}
