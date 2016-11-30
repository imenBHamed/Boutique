package junit.tests.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import app.boutique.dto.Produit;
import app.boutique.model.Panier;

public class PanierTestArrondiDouble {
	
	Panier panier;
	
	@Before
	public void initPanierTest(){
		panier = new Panier();	
	}
	
	@Test
	public void testArrondiDoubleInferieurACinq(){	
		assertEquals("Arrondi Double 3eme chiffre <5 ", 240.45, panier.arrondiDouble(240.454557),0);
	}
	
	@Test
	public void testArrondiDoubleSuperieurACinq(){	
		assertEquals("Arrondi Double 3eme chiffre >5", 65.88, panier.arrondiDouble(65.87645),0);
	}


	@Test
	public void testArrondiDoubleEgalACinq(){	
		assertEquals("Arrondi Double 3eme chiffre =5", 23.76, panier.arrondiDouble(23.7554),0);
	}

}
