package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.learning.j10.model.Client;
import com.learning.j10.utilities.GLOBAL;

public class RowUpdateV2 {
	public static void main(String[] args) {
		
		String SQL = "UPDATE TAXUSER.CLIENTS " + 
    			"SET FIRSTNAME=?, LASTNAME=?, CURRENTSALARY=?, STATUS=? " + 
    			"WHERE CLIENTID=?";


        try (Connection conn = DriverManager.getConnection(GLOBAL.URL);
        	 PreparedStatement ps = conn.prepareStatement(SQL)) {

        	
        	Client client = new Client(1000,"Hermann","Sterling's",500_000f, "MFJ");
			ps.setString(1,client.getFirstName() + "");
			ps.setString(2,client.getLastName());
			ps.setFloat(3,client.getCurrentSalary());
			ps.setString(4,client.getStatus());
			ps.setInt(5,client.getClientId());
			
			int row = ps.executeUpdate();
			System.out.println("Update status is....." + row);

        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
