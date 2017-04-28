package me.newsong.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import me.newsong.domain.User;
import me.newsong.exception.UsernameExistedException;

public class UserServiceTest {
	private UserService service;
	@Before
	public void setUp() throws Exception {
		service = new UserService();
	}

	@Test
	public void testFindByUsername() {
		User user = service.findByUsername("songxinjianqwe");
		System.out.println(user);
		assertNotNull(user);
		assertEquals(user.getUsername(),"songxinjianqwe");
		assertEquals(user.getPassword(),"sxj");
	}
	
	@Test
	public void testAddUser() throws UsernameExistedException{
		User user = new User("admin","admin");
		service.addUser(user);
		User u2 = service.findByUsername("admin");
		assertNotNull(u2);
		assertEquals(u2.getPassword(),"admin");
	}

}
