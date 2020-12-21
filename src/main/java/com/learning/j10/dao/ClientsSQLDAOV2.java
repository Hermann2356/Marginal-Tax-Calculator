package com.learning.j10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jbbwebsolutions.dao.IQuery;
import com.learning.j10.model.Client;

public class ClientsSQLDAOV2 implements IQuery<Client>{

	
	@Override
	public List<Client> findAll() {
		String url = "jdbc:derby://localhost:1527/taxrulesDB;create=false";
		String sql = "SELECT * FROM Clients";
		List<Client> clients = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(url, "taxUser", "password1234");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)
		){
			
			while(rs.next()) {
				int clientId = rs.getInt("clientId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				float currentSalary = rs.getFloat("currentSalary");
				String status = rs.getString("status");
				
				clients.add(new Client(clientId, firstName, lastName, currentSalary, status));
			}
		}
		catch(SQLException ec) {
//			Logger lgr = Logger.getLogger(ClientsSQLDAOV2.class.getName());           
//            lgr.log(Level.SEVERE, ec.getMessage(), ec);
		}
		
		return clients;
	}
	public static void main(String[]args) {
		ClientsSQLDAOV2 dao = new ClientsSQLDAOV2();
		dao.findAll().forEach(System.out::println);
	}

}
