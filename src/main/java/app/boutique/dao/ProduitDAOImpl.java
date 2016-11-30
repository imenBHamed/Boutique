package app.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import app.boutique.dto.Produit;

 

public class ProduitDAOImpl implements IProduitDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Produit getProduitById(int idProduit) {
		return em.find(Produit.class, idProduit);
	}

	@Override
	public List<Produit> lisProduits() {
		List<Produit> produits = null;
		String req = "SELECT p FROM Produit p";
		Query result = em.createQuery(req);
		produits = result.getResultList();
		return produits;
	}

}
