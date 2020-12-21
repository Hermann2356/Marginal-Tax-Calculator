package com.learning.j10.test.jdbc;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jbbwebsolutions.utility.ESQL;
import com.learning.j10.dao.ClientDAO;
import com.learning.j10.model.Client;
import com.learning.j10.services.ClientService;
import com.learning.j10.utilities.GLOBAL;

public class TestDelete {
	
	@Test
	void t1() {
		ClientDAO dao = new ClientDAO(ESQL.CONNECTION, GLOBAL.URL);
		ClientService service = new ClientService(dao);
		Client client = new Client(1000,"Hermann","Sterling's",1_500_000f,"MFJ");
		int status = service.delete(client);
		
		assertEquals(status,1);
		
		
	}
}
