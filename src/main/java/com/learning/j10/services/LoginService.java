package com.learning.j10.services;

import java.util.Map;

import com.citytech.basicsecurity.SimpleEncryption;
import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.exception.CustomException;
import com.jbbwebsolutions.service.IService;
import com.learning.j10.dao.AbstractUserLoginDAO;
import com.learning.j10.dao.LoginDAO;
import com.learning.j10.model.UserLogin;
import com.learning.j10.utilities.Utility;

public class LoginService implements IService<String, Boolean> {
	
	AbstractUserLoginDAO dao = null;
	
	public LoginService() {
		this.dao = new LoginDAO();
	}
	
	public LoginService(IQuery<UserLogin> dao) {
		this.dao = (AbstractUserLoginDAO) dao;
	}

	@Override
	public Boolean calculate(Map<String, Object> search) throws CustomException {
		if(search == null)
			return false;
		
		String password = Utility.ifNull(search::get, "password", "na");
		String userId = Utility.ifNull(search::get, "userId", "na");
		boolean isValidPassword = false;
		
		String encryptedPassword = SimpleEncryption.encrypt(password);
		UserLogin user = Utility.ifNull(dao::findOne,new UserLogin(userId, encryptedPassword) , null);
		
		if(user == null) {
			 return isValidPassword;
		}
		else if(userId.equals(user.getUserId()) && 
				encryptedPassword.equals(user.getEncryptedPassword())) {
			isValidPassword = true;
		}
		
		return isValidPassword;
	}
	
}
