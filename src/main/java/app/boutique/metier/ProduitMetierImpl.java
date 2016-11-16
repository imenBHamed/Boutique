package app.boutique.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import app.boutique.dao.ProduitDAOImpl;
import app.boutique.dto.Produit;

 
@Transactional
public class ProduitMetierImpl implements IProduitMetier {

	public ProduitDAOImpl produitDAO;

	public void setProduitDAO(ProduitDAOImpl produitDAO) {
		this.produitDAO = produitDAO;
	}

	@Override
	public Produit getProduitById(long idProduit) {
		return produitDAO.getProduitById(idProduit);
	}

	@Override
	public List<Produit> lisProduits() {
		return produitDAO.lisProduits();
	}

}
