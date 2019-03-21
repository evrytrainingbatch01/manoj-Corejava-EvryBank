package com.evry.Admin;

import java.util.List;
import java.util.Map;

public interface EbAdminOperations {
	
	/**CRUD opration to customer**/
	
	  public List<Map<String, Object>> eb_getAllCustomers();
	  
	  public int eb_addNewCustomer();
	  
	  public int eb_updateCustomer();
	  
	  public int eb_deleteCustomer();
	  
	/** special Extra operation from admin  **/
	  
	  public int eb_addMoney();
	  
	  public int eb_approveTransaction();
	  
	  public int eb_provideLoans();
	 

}
