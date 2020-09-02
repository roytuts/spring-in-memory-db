package com.roytuts.spring.embedded.hsqldb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.embedded.hsqldb.model.Customer;
import com.roytuts.spring.embedded.hsqldb.row.mapper.CustomerRowMapper;

@Repository
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL_NEW_CUSTOMER = "INSERT INTO CUSTOMER(CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_CITY, CUSTOMER_STATE, CUSTOMER_ZIP_POSTAL) VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE_CUSTOMER = "UPDATE CUSTOMER SET CUSTOMER_NAME = ?, CUSTOMER_ADDRESS = ?, CUSTOMER_CITY = ?, CUSTOMER_STATE = ?, CUSTOMER_ZIP_POSTAL = ? WHERE CUSTOMER_ID = ?";
	private static final String SQL_DELETE_CUSTOMER = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
	private static final String SQL_FIND_ALL_CUSTOMERS = "SELECT * FROM CUSTOMER";
	private static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

	public Customer findByCustomerId(long customerId) {
		Customer customer = jdbcTemplate.queryForObject(SQL_FIND_BY_CUSTOMER_ID, new CustomerRowMapper(),
				new Object[] { customerId });
		return customer;
	}

	public List<Customer> findAllCustomers() {
		List<Customer> customers = jdbcTemplate.query(SQL_FIND_ALL_CUSTOMERS, new CustomerRowMapper());
		return customers;
	}

	public void saveCustomer(Customer customer) {
		jdbcTemplate.update(SQL_NEW_CUSTOMER, new Object[] { customer.getCustomerName(), customer.getCustomerAddress(),
				customer.getCustomerCity(), customer.getCustomerState(), customer.getCustomerZip() });
	}

	public void updateCustomer(Customer customer) {
		jdbcTemplate.update(SQL_UPDATE_CUSTOMER,
				new Object[] { customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerCity(),
						customer.getCustomerState(), customer.getCustomerZip(), customer.getCustomerId() });
	}

	public void deleteCustomer(long customerId) {
		jdbcTemplate.update(SQL_DELETE_CUSTOMER, new Object[] { customerId });
	}

}
