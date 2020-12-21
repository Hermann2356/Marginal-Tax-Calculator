package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectTaxRulesV2 {
    
    public static void main(String[] args) {      

        String url = "jdbc:derby://localhost:1527/taxrulesDB;create=false";
        
        // try catch resource 
        try (Connection con = DriverManager.getConnection(url, "taxUser", "password1234");   
        		Statement st = con.createStatement();
        		ResultSet rs = st.executeQuery("SELECT * FROM TaxRules");
        		) {         

            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(" ");
                System.out.print(rs.getInt(2));
                System.out.print(" ");
                System.out.print(rs.getFloat(3));
                System.out.print(" ");
                System.out.println(rs.getString(4));
            }         

        } catch (SQLException ec ) {            
            Logger lgr = Logger.getLogger(SelectTaxRulesV2.class.getName());           
            lgr.log(Level.SEVERE, ec.getMessage(), ec);
        } 
    }
}