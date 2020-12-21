package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectTaxRulesV1 {
    
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:derby://localhost:1527/taxrulesDB;create=false";

        try {          
        
        	con = DriverManager.getConnection(url, "taxUser", "password1234");          
            st = con.createStatement();
            //rs = st.executeQuery("SELECT * FROM TaxRules");
            rs = st.executeQuery("SELECT (RULENO,TAXYEAR,RATE,STATUS,RANGE1,RANGE2,TAXABLEAMOUNT,TAXPAID) "
            		+ "FROM TAXUSER.TAXRULES");

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
            
            Logger lgr = Logger.getLogger(SelectTaxRulesV1.class.getName());           
            lgr.log(Level.SEVERE, ec.getMessage(), ec);
           

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(SelectTaxRulesV1.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}