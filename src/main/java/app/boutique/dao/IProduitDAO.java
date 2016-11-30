package app.boutique.dao;

import java.util.List;

import app.boutique.dto.Produit;

 


public interface IProduitDAO {
	public Produit getProduitById (int idProduit);
	public List<Produit> lisProduits();
	
}
