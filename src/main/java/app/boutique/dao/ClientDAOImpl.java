package app.boutique.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import app.boutique.dto.Client;





public class ClientDAOImpl implements ICLientDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client getClientByEmail(String email) {
		Client client= null;
		String sql = "Select c From Client c Where c.email = :x";
		Query query = entityManager.createQuery(sql);
		query.setParameter("x", email);
		if (!query.getResultList().isEmpty()){
			client = (Client)query.getSingleResult();
		}
		return  client;

	}

	@Override
	public void insertClient(Client client) {
		entityManager.persist(client);		
	}

}
