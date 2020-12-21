package com.learning.j10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.utility.ESQL;
import com.learning.j10.model.UserLogin;
import com.learning.j10.utilities.GLOBAL;

public class LoginDAO extends AbstractUserLoginDAO{
	private ESQL eSQL;
	private String url;
	private UserLogin user;
	
	private final String SQL = "SELECT * " + 
			"FROM TAXUSER.USERIDANDENCRYPTEDPASSWORD";
	
	
	
	private String addOn;

	
	public LoginDAO(ESQL eSQL, String url) {
		this.eSQL = eSQL;
		this.url = url;
	}

	public LoginDAO() {
		this.eSQL = ESQL.DATASOURCE;
		this.url = GLOBAL.SERVURL;
	}
	
	@Override
	public UserLogin findOne(UserLogin model) throws DataRepositoryCustomException {
		addOn = SQL + " WHERE USERID ='" + model.getUserId() + "'";
		// try catch resource 
        try (Connection con = DriverManager.getConnection(url);
        		Statement st = con.createStatement();
        		ResultSet rs = st.executeQuery(addOn);
        		) {         

            while (rs.next()) {
               String userId = rs.getString("userId");
               String password = rs.getString("encryptedPassword");
               user = new UserLogin(userId, password);
            }         

        } catch (SQLException ec ) {            
            Logger lgr = Logger.getLogger(LoginDAO.class.getName());           
            lgr.log(Level.SEVERE, ec.getMessage(), ec);
        } 
		return user;
	}



	@Override
	public String toString() {
		return "LoginDAO [eSQL=" + eSQL + ", url=" + url + "]";
	}

}
