package com.roytuts.spring.embedded.hsqldb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.embedded.hsqldb.model.Customer;
import com.roytuts.spring.embedded.hsqldb.service.CustomerService;

@SpringBootApplication
public class SpringEmbeddedHsqlDbApp implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmbeddedHsqlDbApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Customer information with Customer Id = 2");
		Customer findCustomer = customerService.findByCustomerId(2);
		System.out.println(findCustomer);

		System.out.println();
		System.out.println("List all Customers");

		List<Customer> customers = customerService.findAllCustomers();
		customers.stream().forEach(c -> System.out.println(c));

		System.out.println();
		System.out.println("Add new Customer");
		Customer customer = new Customer();
		customer.setCustomerName("Soumitra Roy");
		customer.setCustomerAddress("Tiruvanmiyur");
		customer.setCustomerCity("Chennai");
		customer.setCustomerState("Tamil Nadu");
		customer.setCustomerZip("600020");
		customerService.saveCustomer(customer);

		System.out.println();
		System.out.println("New customer information");
		Customer cust = customerService.findByCustomerId(6);
		System.out.println(cust);

		System.out.println();
		System.out.println("After creating a new Customer, list all Customers");
		List<Customer> customersAfterAddition = customerService.findAllCustomers();
		customersAfterAddition.stream().forEach(c -> System.out.println(c));

		System.out.println();
		System.out.println("Update customer information for Customer Id = 6");
		Customer customerUpdate = customerService.findByCustomerId(6);
		customerUpdate.setCustomerAddress("Chingrihata");
		customerUpdate.setCustomerCity("Kolkata");
		customerUpdate.setCustomerState("West Bengal");
		customerUpdate.setCustomerZip("700105");
		customerService.updateCustomer(customerUpdate);

		System.out.println();
		System.out.println("After updating customer information for Customer Id = 6");
		Customer custUpdate = customerService.findByCustomerId(6);
		System.out.println(custUpdate);

		System.out.println();
		System.out.println("Delete customer information for Customer Id = 6");
		customerService.deleteCustomer(6);

		System.out.println();
		System.out.println("After deleting a Customer for Customer Id = 6, list all Customers");
		List<Customer> customersAfterDeletion = customerService.findAllCustomers();
		customersAfterDeletion.stream().forEach(c -> System.out.println(c));
	}

}
