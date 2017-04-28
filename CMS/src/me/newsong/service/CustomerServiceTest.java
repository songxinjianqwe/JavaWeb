package me.newsong.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import me.newsong.domain.Customer;

public class CustomerServiceTest {
	private CustomerService service;
	@Before
	public void setUp() throws Exception {
		service = new CustomerService();
	}

	@Test
	public void testFindByID(){
		Customer customer = service.findByID(1);
		System.out.println(customer);
		assertNotNull(customer);
		assertEquals(customer.getCname(),"宋欣建");
	}
	
	@Test
	public void testAdd() {
		Customer customer = new Customer("哒哒", "女", new Date(), "12532319923","dada@163.com","hehehe");
		service.add(customer);
		Customer c2 = service.findByID(3);
		assertEquals(c2.getCname(),"哒哒");
	}

}
