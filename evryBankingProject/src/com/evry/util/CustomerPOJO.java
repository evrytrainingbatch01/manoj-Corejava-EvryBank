package com.evry.util;

public class CustomerPOJO {

private String customerFirstName;
private String customerLastName;
private String customerPassword;
private String customerMobileNum;
private String customerEmailId;
private String customerCity;
private String customerCountry;
private int customerAge;
public String getCustomerFirstName() {
	return customerFirstName;
}
public void setCustomerFirstName(String customerFirstName) {
	this.customerFirstName = customerFirstName;
}
public String getCustomerLastName() {
	return customerLastName;
}
public void setCustomerLastName(String customerLastName) {
	this.customerLastName = customerLastName;
}
public String getCustomerPassword() {
	return customerPassword;
}
public void setCustomerPassword(String customerPassword) {
	this.customerPassword = customerPassword;
}
public String getCustomerMobileNum() {
	return customerMobileNum;
}
public void setCustomerMobileNum(String customerMobileNum) {
	this.customerMobileNum = customerMobileNum;
}
public String getCustomerEmailId() {
	return customerEmailId;
}
public void setCustomerEmailId(String customerEmailId) {
	this.customerEmailId = customerEmailId;
}
public String getCustomerCity() {
	return customerCity;
}
public void setCustomerCity(String customerCity) {
	this.customerCity = customerCity;
}
public String getCustomerCountry() {
	return customerCountry;
}
public void setCustomerCountry(String customerCountry) {
	this.customerCountry = customerCountry;
}
public int getCustomerAge() {
	return customerAge;
}
public void setCustomerAge(int customerAge) {
	this.customerAge = customerAge;
}
@Override
public String toString() {
	return "CustomerPOJO [customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
			+ ", customerPassword=" + customerPassword + ", customerMobileNum=" + customerMobileNum
			+ ", customerEmailId=" + customerEmailId + ", customerCity=" + customerCity + ", customerCountry="
			+ customerCountry + ", customerAge=" + customerAge + "]";
}


}
