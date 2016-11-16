package app.boutique.metier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;








import org.springframework.transaction.annotation.Transactional;

import app.boutique.dao.ClientDAOImpl;
import app.boutique.dto.Client;

 
@Transactional
public class ClientMetierImpl implements IClientMetier{

	public ClientDAOImpl clientDAO;

	@PersistenceContext
	private EntityManager entityManager;

	public void setClientDAO(ClientDAOImpl clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public Client getClientByEmail(String email) {

		return  clientDAO.getClientByEmail(email);
	}

}
