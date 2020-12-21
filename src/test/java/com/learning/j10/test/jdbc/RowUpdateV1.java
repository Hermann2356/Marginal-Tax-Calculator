package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.learning.j10.model.Client;
import com.learning.j10.utilities.GLOBAL;

public class RowUpdateV1 {
	public static void main(String[] args) {
		
		

        try (Connection conn = DriverManager.getConnection(GLOBAL.URL);   
             Statement statement = conn.createStatement()) {

            
			Client client = new Client(1000,"Hermann","Sterling's",500_000f, "MFJ");
			int row = statement.executeUpdate(updateClient(client));

            // rows affected
            System.out.println(row);


        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String updateClient(Client client) {
    	String SQL = "UPDATE TAXUSER.CLIENTS " + 
    			"SET FIRSTNAME='$fname', LASTNAME='$lname', CURRENTSALARY=$salary, STATUS='$status' " + 
    			"WHERE CLIENTID=$clientId";
    	
    	String newSQL = 
    			SQL.replace("$fname",client.getFirstName())
    			.replace("$lname",client.getLastName())
    			.replace("$salary",client.getCurrentSalary() + "")
    			.replace("$status",client.getStatus())
    			.replace("$clientId",client.getClientId() + "");
    	
    	System.out.println(newSQL);
    			
        return newSQL;

    }
}
