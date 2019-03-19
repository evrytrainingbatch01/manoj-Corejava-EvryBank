package com.evry.Admin;

public interface EbAdminOperations {
	
	/**CRUD opration to customer**/
	
	  public int eb_getAllCustomers();
	  
	  public int eb_addNewCustomer();
	  
	  public int eb_updateCustomer();
	  
	  public int eb_deleteCustomer();
	  
	/** special Extra operation from admin  **/
	  
	  public int eb_addMoney();
	  
	  public int eb_approveTransaction();
	  
	  public int eb_provideLoans();
	 

}
