package com.evry.Customer;

import java.util.List;
import java.util.Map;

public interface EbCustomerOperations {
	
	public List<Map<String, Object>> Eb_getAccountDetails(int custId);
	
	public int Eb_addMoney(int custId);
	
	public int Eb_sendMoney(int custId);
	
	public int Eb_withDrawMoney(int custId);
	
	public int Eb_requistingLoan(int custId);

}
