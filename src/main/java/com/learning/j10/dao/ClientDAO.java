package com.learning.j10.dao;

import java.util.List;

import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.learning.j10.model.Client;
import com.learning.j10.utilities.GLOBAL;

public class ClientDAO extends AbstractClientDAO {
	private ESQL eSQL;
	private String url;
	
	private final static String SQL = "SELECT CLIENTID, FIRSTNAME, LASTNAME, CURRENTSALARY, STATUS " + 
			"FROM TAXUSER.CLIENTS "
			+ " WHERE (1=1)";
	
	private String addOn;
	private Client model;
	
	public ClientDAO(ESQL eSQL, String url) {
		this.eSQL = eSQL;
		this.url = url;
	}

	public ClientDAO() {
		this.eSQL = ESQL.DATASOURCE;
		this.url = GLOBAL.SERVURL;
	}

	
	
	@Override
	public List<Client> findBy(Client model) {
		addOn = SQL + " and (status = 	? OR 'ALL' = ?)";
		addOn += " and (clientId  = ? OR -999 = ?)";
		this.model = model;
		return this.findAll();
	}

	@Override
	public List<Client> findAll() {
		
		SQLExecutable<Client> executable = rs -> {
			int clientID = rs.getInt("clientId");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			float currentSalary = rs.getFloat("currentSalary");
			String status = rs.getString("status");

			return new Client(clientID, firstName, lastName, currentSalary, status);

		};
		
//		System.out.println("SQL SENT: " + addOn);
//		System.out.println("Model: " + this.model);
		List<Client> clients = SQLUtility.execute(addOn, url, eSQL, executable, 
				model.getStatus(), model.getStatus(),
				model.getClientId(), model.getClientId());
		
		
		return clients;
	}

	@Override
	public String toString() {
		return "ClientSQLDAO [eSQL=" + eSQL + ", url=" + url + "]";
	}
	
	final static String UPDATE_SQL = "UPDATE TAXUSER.CLIENTS " 
			+ "SET STATUS=? "
			+ ", CURRENTSALARY=? "
			+ "WHERE CLIENTID=?";

	@Override
	public int save(Client client) throws DataRepositoryCustomException{
		
		int status = 0;
		try {
			status = SQLUtility.update(UPDATE_SQL, url, eSQL
					,client.getStatus()
					,client.getCurrentSalary()
					,client.getClientId());
		} catch (Exception e) {
			
			throw new DataRepositoryCustomException(e.getMessage());
			
		}
	
		return status;
	}
	
	final static String DELETE_SQL = "DELETE TAXUSER.CLIENTS " 
			+ "WHERE CLIENTID=?";

	
	public int delete(Client client) throws DataRepositoryCustomException{
		int status = 0;
		try {
			status = SQLUtility.update(DELETE_SQL, url, eSQL
					,client.getClientId());
			
		} catch (Exception e) {
			
			throw new DataRepositoryCustomException(e.getMessage());
			
		}
	
		return status;
	}

}
