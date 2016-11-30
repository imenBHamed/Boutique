package junit.tests.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import app.boutique.dto.Produit;
import app.boutique.model.Panier;

public class PanierTestTotaux {
	
	Produit produit1;
	List<Produit> produits;
	Panier panier;
	
	@Before
	public void initPanierTest(){
		produit1 = Mockito.mock(Produit.class);
	    produits = new ArrayList<Produit>(1);
		Mockito.when(produit1.getPrix()).thenReturn((Double)210.00);
		Mockito.when(produit1.getQuantitePanier()).thenReturn(1);
		Mockito.when(produit1.getPrixTotal()).thenReturn(210.00);
		panier = new Panier();
		panier.addPanier(produit1);
		Double d =0.00;
		for (Produit p : panier.getItems())
		{
			d += p.getPrix();
		}
		panier.setTotalHT(d);
	
	}
	
	@Test
	public void testAddPanierTotalHT(){	
		assertEquals("Expected total HT", 210.0, panier.getTotalHT(),0);
	}
	
	@Test
	public void testAddPanierTotalTPS(){	
		assertEquals("Expected total TPS",10.5, panier.getTotalTPS(),0);
	}
	
	@Test
	public void testAddPanierTVQ(){	
		assertEquals("Expected total TVQ", 19.95, panier.getTotalTVQ(),0);
	}
	
	@Test
	public void testAddPanierTotal(){	
		assertEquals("Expected total", 240.45, panier.getTotal(),0);
	}
	

}
