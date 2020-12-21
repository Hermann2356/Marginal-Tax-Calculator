package com.learning.j10.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.utility.ESQL;
import com.learning.j10.dao.ClientDAO;
import com.learning.j10.model.Client;
import com.learning.j10.services.ClientService;
import com.learning.j10.utilities.GLOBAL;

public class TestClientDAO {

	public static void main(String[] args) {
		ClientDAO dao = new ClientDAO(ESQL.CONNECTION, GLOBAL.URL);

		IService<Client, Client> service = new ClientService(dao);
		Map<String, Object> search = new HashMap<>();
		search.put("status", "ALL");
		search.put("clientId", -999);

		service.search(search).forEach(System.out::println);

	}

	@Test
	@DisplayName("Test for Id 1001")
	public void t1() {
		ClientDAO dao = new ClientDAO(ESQL.CONNECTION, GLOBAL.URL);
		IService<Client, Client> service = new ClientService(dao);
		Map<String, Object> search = new HashMap<>();
		search.put("status", "ALL");
		search.put("clientId", 1001);
		
		int count = service.search(search).size();

		assertEquals(1, count);

	}
	@Test
	@DisplayName("Testing for no parameter passed in")
	public void t2() {
		ClientDAO dao = new ClientDAO(ESQL.CONNECTION, GLOBAL.URL);
		IService<Client, Client> service = new ClientService(dao);
		Map<String, Object> search = new HashMap<>();
		
		
		int size = service.search(search).size();
	
		assertTrue(size > 100);
	
	}
	
	@Test
	@DisplayName("Testing status equals to ALL")
	public void t3() {
		ClientDAO dao = new ClientDAO(ESQL.CONNECTION, GLOBAL.URL);

		IService<Client, Client> service = new ClientService(dao);
		Map<String, Object> search = new HashMap<>();
		
		search.put("status", "ALL");
		
		int size = service.search(search).size();

		assertTrue(size > 100);

	}
	
//	@Test
//	@DisplayName("Client Update, for record 1002")
//	public void t4() {
//		ClientDAO dao = new ClientDAO(ESQL.CONNECTION, GLOBAL.URL);
//
//		IService<Client, Client> service = new ClientService(dao);
//		Map<String, Object> search = new HashMap<>();
//		
//		Client client = new Client();
//		client.setStatus("S");
//		service.save(client);
//		
//		//assertTrue(size > 100);
//
//	}

	
}
