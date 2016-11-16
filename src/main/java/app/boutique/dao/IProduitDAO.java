package app.boutique.dao;

import java.util.List;

import app.boutique.dto.Produit;

 


public interface IProduitDAO {
	public Produit getProduitById (long idProduit);
	public List<Produit> lisProduits();
	
}
