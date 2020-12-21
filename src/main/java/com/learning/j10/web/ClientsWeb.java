package com.learning.j10.web;

import static com.learning.j10.utilities.Utility.isNull;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbbwebsolutions.service.IService;
import com.learning.j10.model.Client;
import com.learning.j10.services.ClientService;


/**
 * Servlet implementation class ClientsWeb
 */
public class ClientsWeb extends _AbstractWeb {
	private static final long serialVersionUID = 1L;

	protected void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = this.getURLPattern(request);		
		

		if (url.equals("client.view"))
			viewOne(request, response);
		else if(url.equals("clients"))
			showAll(request, response);
		else if(url.equals("client.update"))
			update(request,response);
	}

	protected void viewOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IService<Client, Client> service = new ClientService();
		Map<String, Object> search = new HashMap<>();

		int clientId = Integer.parseInt(isNull(request::getParameter, "clientId", "-999"));
		search.put("clientId", clientId);

		List<Client> clients = service.search(search);

		Client client = clients.get(0);

		request.setAttribute("client", client);
		this.redirect("/WEB-INF/clientUpdate.jsp", request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IService<Client, Client> service = new ClientService();

		int clientId = Integer.parseInt(isNull(request::getParameter, "clientId", "-999"));
		String status = isNull(request::getParameter,"status", "NA");
		float salary = Float.parseFloat(request.getParameter("salary"));
		Client client = new Client();
		client.setStatus(status);
		client.setCurrentSalary(salary);
		client.setClientId(clientId);
		
		service.save(client);
		request.setAttribute("client", client);
		this.redirect("clients?status=ALL", request, response);
	}

	protected void showAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IService<Client, Client> service = new ClientService();
		Map<String, Object> search = new HashMap<>();

			
		
		
		String status = request.getParameter("status");
		search.put("status",status);
		
		List<Client> clients = service.search(search);
		request.setAttribute("clients", clients);
		
		Date timeStamp = new Date();
		request.setAttribute("timestamp", timeStamp);
		
		this.redirect("/WEB-INF/clients.jsp", request, response);
	}

	

}
