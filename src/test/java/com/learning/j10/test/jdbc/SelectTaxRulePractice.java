package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectTaxRulePractice {
	
	
	public static void main(String[]args) {
		
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		
		String url = "jdbc:derby://localhost:1527/taxrulesDB;create=false";
		
		try {
			con = DriverManager.getConnection(url,"taxUser", "password1234");
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM TAXRULES WHERE TAXYEAR = 2020");
			List<Object> taxRule = new ArrayList<>();
			while(rs.next()) {
				taxRule.add( rs.getString("ruleNo"));
				taxRule.add(rs.getInt("taxYear"));
				taxRule.add(rs.getFloat("rate"));
				taxRule.add(rs.getString("status"));
				taxRule.add(rs.getFloat("range1"));
				taxRule.add(rs.getFloat("range2"));
				taxRule.add(rs.getFloat("taxableAmount"));
				taxRule.add(rs.getFloat("taxPaid"));
			}
			
			taxRule.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
