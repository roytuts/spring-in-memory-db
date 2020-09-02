package com.roytuts.spring.embedded.hsqldb.model;

public class Customer {

	private Long customerId;
	private String customerName;
	private String customerAddress;
	private String customerCity;
	private String customerState;
	private String customerZip;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerZip() {
		return customerZip;
	}

	public void setCustomerZip(String customerZip) {
		this.customerZip = customerZip;
	}

	@Override
	public String toString() {
		return "[ Customer Id : " + customerId + ", Customer Name : " + customerName + ", Customer Address : "
				+ customerAddress + ", Customer City : " + customerCity + ", Customer State : " + customerState
				+ ", Customer Zip Code : " + customerZip + "]";
	}

}
