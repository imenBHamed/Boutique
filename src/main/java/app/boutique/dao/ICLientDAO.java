package app.boutique.dao;

import app.boutique.dto.Client;

 


public interface ICLientDAO {
	
	public Client getClientByEmail (String email);
	public void insertClient(Client client);
	
}
