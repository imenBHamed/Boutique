package app.boutique.metier;

import app.boutique.dto.Client;

 

public interface IClientMetier {
	public Client getClientByEmail (String email);
}
