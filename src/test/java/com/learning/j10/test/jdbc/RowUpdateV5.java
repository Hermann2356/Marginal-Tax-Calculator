package com.learning.j10.test.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.utility.ESQL;
import com.learning.j10.dao.ClientDAO;
import com.learning.j10.model.Client;
import com.learning.j10.utilities.GLOBAL;

public class RowUpdateV5 {

//	public void t1(){
//		final String SQL = "UPDATE TAXUSER.CLIENTS " + 
//    			"SET FIRSTNAME=?, LASTNAME=?, CURRENTSALARY=?, STATUS=? " + 
//    			"WHERE CLIENTID=?";
//		
//		Client client = new Client(1000,"Hermann","Sterling's",1_500_000f, "MFJ");
//		int status = SQLUtility.update(SQL, GLOBAL.URL, ESQL.CONNECTION, 
//				client.getFirstName(),
//				client.getLastName(),
//				client.getCurrentSalary(),
//				client.getStatus(),
//				client.getClientId());
//		
//		System.out.println("Status is " + status);
//	
//    }

	@Test
	@DisplayName("Testing for Exception")
	public void t1() {

		Assertions.assertThrows(DataRepositoryCustomException.class, () -> {
			testInvalidStatus();
		});

	}

	public static void testInvalidStatus() {

		ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;

		ClientDAO dao = new ClientDAO(eSQL, url);

		Client client = new Client();
		client.setClientId(1002);
		/*
		 * MFY is an invalid status
		 */
		client.setStatus("MFY");

		int status = dao.save(client);
		assertEquals(status, 1);

	}

	@Test
	@DisplayName("Testing for 1002")
	public void t2() {

		ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;

		ClientDAO dao = new ClientDAO(eSQL, url);

		Client client = new Client();
		client.setClientId(1002);
		client.setStatus("MFJ");

		int status = dao.save(client);
		assertEquals(status, 1);

	}

	@Test
	@DisplayName("Testing for 1003")
	public void t3() {
		
		ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;
		
		ClientDAO dao = new ClientDAO(eSQL, url);
		
		Client client = new Client();
		client.setClientId(1002);
		client.setStatus("MFJ");
		client.setCurrentSalary(0f);
		
		int status = dao.save(client );
		assertEquals(status, 1);

	}
}
