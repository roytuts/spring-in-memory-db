package com.roytuts.spring.embedded.hsqldb.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.spring.embedded.hsqldb.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();

		customer.setCustomerId(rs.getLong("CUSTOMER_ID"));
		customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
		customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
		customer.setCustomerCity(rs.getString("CUSTOMER_CITY"));
		customer.setCustomerState(rs.getString("CUSTOMER_STATE"));
		customer.setCustomerZip(rs.getString("CUSTOMER_ZIP_POSTAL"));

		return customer;
	}

}
