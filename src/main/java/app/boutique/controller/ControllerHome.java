package app.boutique.controller;


 
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RequestParam;

import app.boutique.dto.Produit;
import app.boutique.metier.IProduitMetier;
import app.boutique.model.Panier;

 
 
 
@Controller
public class ControllerHome {
	
	@Autowired
	private IProduitMetier produitMetier;
	

	
	@RequestMapping(value = "/listProduit")
	public String listProduit(Model model) { 
		List<Produit> produits= produitMetier.lisProduits();
 		model.addAttribute("produits", produits);
		return "listProduit";
	}

	
	@RequestMapping(value="/detailProduit")
	public  String affdetail(Model model,@RequestParam ("id") int id){
		Produit produit = (Produit) produitMetier.getProduitById(id);
		model.addAttribute("produit", produit);
		return "detailProduit";
	}
	
	@RequestMapping(value="/addPanier")
	public String addPanier (HttpSession session, @RequestParam("id") int id, @RequestParam("qte") int qte){
		Panier  panier = (Panier)session.getAttribute("panier");
		Produit produit = produitMetier.getProduitById(id);
		if (panier == null){
			panier = new Panier();
		}
		produit.setQuantitePanier(qte);
		panier.addPanier(produit);
		session.setAttribute("panier", panier);
		return "redirect:/panier.html";
		
	}

	@RequestMapping(value="/panier")
	public  String affPanier(){
		return "panier";
	}
}
								