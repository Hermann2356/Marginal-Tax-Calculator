package com.learning.j10.test.jdbc;

import java.util.List;


import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.learning.j10.model.TaxRule;

public class _04SelectCity {

	public static void main(String[] args) {
		
        String url = "jdbc:derby://localhost:1527/taxrulesDB;create=false;" +
        "user=taxUser;password=password1234";
        
		String sql =  "SELECT * FROM TAXRULES";	
	
		SQLExecutable<TaxRule> executable = rs -> {
			
			
			int ruleNo = rs.getInt("ruleNo");
			int year = rs.getInt("taxYear");
			float rate = rs.getFloat("rate");
			String status = rs.getString("status");
			float range1 = rs.getFloat("range1");
			float range2 = rs.getFloat("range2");
			float taxableAmount = rs.getFloat("taxableAmount");
			float taxPaid = rs.getFloat("taxPaid");
			
			return new TaxRule(ruleNo, year, rate, status, range1, range2, taxableAmount, taxPaid);
		};
		
		List<TaxRule> cars = SQLUtility.execute(sql, url, ESQL.CONNECTION, executable);
	
		cars.forEach(System.out::println);
	}

}
