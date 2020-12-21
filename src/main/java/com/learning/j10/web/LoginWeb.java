package com.learning.j10.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.utility.ESQL;

import static com.jbbwebsolutions.utility.BasicUtility.isNull;

import com.learning.j10.dao.LoginDAO;
import com.learning.j10.services.LoginService;
import com.learning.j10.utilities.GLOBAL;

/**
 * Servlet implementation class LoginWeb
 */
public class LoginWeb extends _AbstractWeb {
	private static final long serialVersionUID = 1L;

	@Override
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IService<String, Boolean> loginService =  new LoginService(new LoginDAO(ESQL.CONNECTION, GLOBAL.URL));
		
		String userId = isNull(request::getParameter, "userId", "na");
		String password = isNull(request::getParameter, "password", "na");
		Map<String, Object> search = new HashMap<>();
		
		search.put("password", password);
		search.put("userId", userId);
		
		boolean isValidPassword = loginService.calculate(search);
		HttpSession session = request.getSession();
		
		if(isValidPassword) {
			session.setAttribute(GLOBAL.IS_SECURED, true);
			this.redirect("/home", request, response);
			return;
		}
		else {
			session.setAttribute(GLOBAL.IS_SECURED, false);
		}

		this.redirect("/WEB-INF/login.jsp", request, response);
	}

}
