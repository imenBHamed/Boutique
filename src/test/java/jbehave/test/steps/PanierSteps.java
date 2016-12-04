package jbehave.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.SeleniumSteps;

import app.boutique.model.Panier;

import com.thoughtworks.selenium.Selenium;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PanierSteps extends SeleniumSteps {
	public Panier panier;

	public PanierSteps(Selenium selenium) {
		super(selenium);
	}

	/* ***************** Test Inscription ***************** */
	
	@Given("l'utilisateur veut s'inscrire")
	public void givenLutilisateurVeutSinscrire() {
		selenium.open("/controller/login.html");
	}

	@When("il saisi son nom $nom , son prenom $prenom , son numero de tel $tel , sa date de naissance $dateNaiss , son adresse email $email et son mot de passe $password")
	public void whenIlSaisiInformations(String nom, String prenom, String tel,
			String dateNaiss, String email, String password) {
		selenium.type("nomClient", nom);
		selenium.type("prenomClient", prenom);
		selenium.type("email", email);
		selenium.type("password", password);
		selenium.type("tel", tel);
		selenium.type("dateNaissance", dateNaiss);
		selenium.click("//button[@title='valider']");
		selenium.waitForPageToLoad("30000");
	}

	@Then("le compte de client $msg")
	public void thenLeClientSestInscrit(String msg) {
		String message = "Votre compte a �t� cr�e avec succ�s, vous pouvez se connecter d�s maintenant!";
		assertThat(selenium.getText("//div[@class='signup-form']/p[2]"),
				equalTo(message));
	}

	@Then("le compte est d�j� existe")
	public void thenLeCompteEstDejaExiste() {
		assertThat(selenium.getText("//div[@class='signup-form']/p[1]"),
				equalTo("Client existe d�j�!"));
	}

	/* ************************ Test Login *************************** */
	
	@Given("le client veut se connecter")
	public void givenLeClientVeutSeConnecter() {
		selenium.open("/controller/login.html");
	}

	@When("il saisit son adresse email $email et son mot de passe $password")
	public void whenIlSaisiEmailPassowd(String email, String password) {
		selenium.type("email_c", email);
		selenium.type("password_c", password);
		selenium.click("//button[@title='login']");
		selenium.waitForPageToLoad("30000");
	}

	@Then("son panier sera affich�")
	public void thenLeClientSeConnecte() {
		assertThat(selenium.getText("//a[@title='valider_panier']"),
				equalTo("Valider Panier"));
	}

	@Then("un message d'erreur $msg sera affich�")
	public void thenUnMsgAffiche(String msg) {
		assertThat(selenium.getText("//div[@class='login-form']/p[1]"),
				equalTo(msg));
	}

	/******************* Test Panier ********************* */
	
	@Given("panier est vide")
	public void givenPaniervide() {
		panier = new Panier();
	}

	@Given("liste de produits contient produit 1 avec prix 1050.21 et produit 2 avec prix 100.12")
	public void givenListeDeProduits() {
		selenium.open("/controller/listProduit.html");
	}

	@When("je selectionne produit $id et je saisi $qte comme quantite")
	public void whenJeCliqueSur(String id, String qte) {
		String xpath = "//a[@onclick=\"window.location.href='detailProduit.html?id="
				+ id + "'\"]";
		selenium.click("xpath=" + xpath);
		selenium.waitForPageToLoad("30000");
		selenium.type("qte", qte);
		selenium.click("ajouter_au_panier");
		selenium.waitForPageToLoad("30000");
	}

	@Then("apres le calcul de TVQ et TPS le totalpanier sera $prix")
	public void thenLeTotalDePanierSera(String prix) {
		String totalPtix = "TOTAL : " + prix + " $";
		assertThat(selenium.getText("css=li:nth-child(3)"), equalTo(totalPtix));
	}
	
	@When("je supprime le produit $id du mon panier")
	public void whenJeSupprimeUnProduitDuMonPanier(String id) {
		String xpath = "//a[@onclick=\"window.location.href='removeItem.html?id="
				+ id + "'\"]";
		selenium.click("xpath=" + xpath);
		selenium.waitForPageToLoad("30000");

	}
	
}
