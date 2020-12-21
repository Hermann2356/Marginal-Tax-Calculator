package com.learning.j10.basicsecurity.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.utility.ESQL;
import com.learning.j10.dao.LoginDAO;
import com.learning.j10.services.LoginService;
import com.learning.j10.utilities.GLOBAL;

public class TestLoginSecurity {
	
	@Test
	@DisplayName("Test True Password")
	void t1() {
		LoginDAO dao = new LoginDAO(ESQL.CONNECTION, GLOBAL.URL);
		IService<String, Boolean> service = new LoginService(dao);
		Map<String, Object> search = new HashMap<>();
		search.put("password", "password1237");
		search.put("userId", "user-103");
		
		boolean status = service.calculate(search);
		
		assertTrue(status);
	}
	
	@Test
	@DisplayName("Test False Password")
	void t3() {
		LoginDAO dao = new LoginDAO(ESQL.CONNECTION, GLOBAL.URL);
		IService<String, Boolean> service = new LoginService(dao);
		Map<String, Object> search = new HashMap<>();
		search.put("password", "password123d7");
		search.put("userId", "user-18");
		
		boolean status = service.calculate(search);
		
		assertFalse(status);
	}
	
	@Test
	@DisplayName("Test False UserId")
	void t4() {
		LoginDAO dao = new LoginDAO(ESQL.CONNECTION, GLOBAL.URL);
		IService<String, Boolean> service = new LoginService(dao);
		Map<String, Object> search = new HashMap<>();
		search.put("password", "password123d7");
		search.put("userId", "user-");
		
		boolean status = service.calculate(search);
		
		assertFalse(status);
	}

}
