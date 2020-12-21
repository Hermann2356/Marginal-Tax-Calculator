package com.learning.j10.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.service.IService;
import com.learning.j10.dao.AbstractClientDAO;
import com.learning.j10.dao.ClientDAO;
import com.learning.j10.model.Client;
import com.learning.j10.utilities.Utility;

public class ClientService implements IService<Client, Client>{
	AbstractClientDAO dao = null;

	public ClientService() {
		this.dao = new ClientDAO();
	}
	
	public ClientService(IQuery<Client> dao) {
		this.dao = (AbstractClientDAO) dao;
	}
	
	
	@Override
	public void save(Client client) {
		dao.save(client);
	}

	public int delete(Client client) {
		return dao.delete(client);
	}
	
	@Override
	public List<Client> search(Map<String, Object> search) {
		if(search == null) {
			return new ArrayList<>();
		}
		
		String status = Utility.ifNull(search::get, "status", "ALL");
		int clientId = Utility.ifNull(search::get, "clientId", -999);
		
		Client model = new Client();
		
		model.setStatus(status);
		model.setClientId(clientId);
		
		List<Client> clients = dao.findBy(model);
		
		clients.stream()
				.collect(Collectors.toList());
		

		return clients;
	}

}
