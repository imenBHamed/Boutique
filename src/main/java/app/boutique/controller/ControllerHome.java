package app.boutique.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app.boutique.dto.Client;

import org.springframework.web.bind.annotation.RequestParam;

import app.boutique.dto.Produit;
import app.boutique.metier.IClientMetier;
import app.boutique.metier.IProduitMetier;
import app.boutique.model.ClientLogin;
import app.boutique.model.Panier;

@Controller
public class ControllerHome {

	@Autowired
	private IProduitMetier produitMetier;

	@Autowired
	private IClientMetier clientMetier;

	public List<Produit> produits = new ArrayList<Produit>();

	@RequestMapping(value = "/listProduit")
	public String listProduit(Model model) {

		produits = produitMetier.lisProduits();

		model.addAttribute("produits", produits);
		return "listProduit";
	}

	@RequestMapping(value = "/detailProduit")
	public String affdetail(Model model, @RequestParam("id") int id) {
		Produit produit = (Produit) produitMetier.getProduitById(id);
		model.addAttribute("produit", produit);
		return "detailProduit";
	}

	@RequestMapping(value = "/addPanier")
	public String addPanier(HttpSession session, @RequestParam("id") int id,
			@RequestParam("qte") int qte) {
		Panier panier = (Panier) session.getAttribute("panier");
		Produit produit = produitMetier.getProduitById(id);
		if (panier == null) {
			panier = new Panier();
		}
		produit.setQuantitePanier(qte);
		panier.addPanier(produit);
		session.setAttribute("panier", panier);
		return "redirect:/panier.html";

	}

	@RequestMapping(value = "/removeItem")
	public String removeItem(HttpSession session, @RequestParam("id") int id) {
		Panier panier = (Panier) session.getAttribute("panier");

		Produit produit = produitMetier.getProduitById(id);
		panier.deletePanier(produit);
		session.setAttribute("panier", panier);
		return "redirect:/panier.html";
	}

	@RequestMapping(value = "/panier")
	public String affPanier() {
		return "panier";
	}

	/*** Client **/

	@RequestMapping(value = "/login")
	public String affLogin(Model model) {
		return "login";
	}

	@RequestMapping(value = "/connecter")
	public String seConnecter(@ModelAttribute ClientLogin client,
			HttpSession session, Model model) {

		Client user = clientMetier.getClientByEmail(client.getEmail_c());

		if (user != null) {
			if (client.getPassword_c().equalsIgnoreCase(user.getPassword())) {

				return "redirect:/panier.html";
			} else {
				model.addAttribute("errors", "mot de passe invalide!");

				return "login";
			}
		}
		model.addAttribute("errors", "Email invalide!");
		return "login";

	}

	@RequestMapping(value = "/inscription")
	public String saveClient(@ModelAttribute Client client, Model model) {
		Client clientOK = clientMetier.getClientByEmail(client.getEmail());
		if (clientOK != null) {
			model.addAttribute("errorsInscription", "Client existe déjà!");
			return "login";
		} else {
			if (!client.getDateNaissance().equals("")) {
				client.setDateNaissance(client.getDateNaissance());
			}
			client.setDateInscription(new Date());
			clientMetier.insertClient(client);
			model.addAttribute("succes",
					"Votre compte a été crée avec succès, vous pouvez se connecter dès maintenant!");
			return "login";
		}
	}
}
