package com.wha.spring.jdbc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wha.spring.jdbc.model.Address;
import com.wha.spring.jdbc.model.Customer;
import com.wha.spring.jdbc.service.CustomerManager;
import com.wha.spring.jdbc.service.CustomerManagerImpl;

public class TransactionManagerMain {
	 public static void main(String[] args) {
	        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
	                "spring.xml");
	 
	        CustomerManager customerManager = ctx.getBean("customerManager",
	                CustomerManagerImpl.class);
	 
	        Customer cust = createDummyCustomer();
	        customerManager.createCustomer(cust);
	 
	        ctx.close();
	    }
	 
	    private static Customer createDummyCustomer() {
	        Customer customer = new Customer();
	        customer.setId(2);
	        customer.setName("David");
	        Address address = new Address();
	        address.setId(2);
	        address.setCountry("France");
	        // setting value more than 20 chars, so that SQLException occurs
	        address.setAddress("37 boulvard Albert 1er, CP 92500");
	        customer.setAddress(address);
	        return customer;
	    }
}
