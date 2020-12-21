package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.learning.j10.model.Client;
import com.learning.j10.utilities.GLOBAL;

public class RowDeleteV3 {
	public static void main(String[] args) {
		
		String SQL = "DELETE FROM TAXUSER.CLIENTS " + 
    			"WHERE CLIENTID=?";


        try (Connection conn = DriverManager.getConnection(GLOBAL.URL);
        		PreparedStatement ps = conn.prepareStatement(SQL)) {

        	
        	Client client = new Client(1000,"Hermann","Sterling's",500_000f, "MFJ");
			ps.setInt(1,client.getClientId());
			
			int row = ps.executeUpdate();
			System.out.println("Update status is....." + row);

        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
