package app.boutique.metier;

import java.util.List;

import app.boutique.dao.ProduitDAOImpl;
import app.boutique.dto.Produit;
 

public interface IProduitMetier {
	
	public Produit getProduitById(long idProduit);
	public List<Produit> lisProduits();
}
