package app.boutique.metier;

import java.util.List;
import app.boutique.dto.Produit;
 
public interface IProduitMetier {
	
	public Produit getProduitById(int idProduit);
	public List<Produit> lisProduits();
}
