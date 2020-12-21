package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.learning.j10.model.Client;
import com.learning.j10.utilities.GLOBAL;

public class RowInsertV4 {
	public static void main(String[] args) {
		
		String SQL = "INSERT INTO TAXUSER.CLIENTS " + 
    			"(CLIENTID, FIRSTNAME, LASTNAME, CURRENTSALARY, STATUS)"
    			+ "VALUES(?, ?, ?, ?, ?)";;


        try (Connection conn = DriverManager.getConnection(GLOBAL.URL);
        		PreparedStatement ps = conn.prepareStatement(SQL)) {

        	
        	Client client = new Client(1000,"Hermann","Sterling's",500_000f, "MFJ");
        	ps.setInt(1,client.getClientId());
        	ps.setString(2,client.getFirstName() + "");
			ps.setString(3,client.getLastName());
			ps.setFloat(4,client.getCurrentSalary());
			ps.setString(5,client.getStatus());
			
			
			int row = ps.executeUpdate();
			System.out.println("Update status is....." + row);

        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
