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

	@Given("panier est vide")
	public void givenPaniervide() {
		panier = new Panier();
	}

	@Given("liste de produits contient produit 1 avec prix 1050.215 et produit 2 avec prix 100.125")
	public void givenListeDeProduits() {
		selenium.open("/controller/listProduit.html");
	}

	@When("je selectionne produit $id et je saisi $qte comme quantite")
	public void whenJeCliqueSur(String id, String qte) {
		String xpath = "//a[@onclick=\"window.location.href='detailProduit.html?id="+ 1 + "'\"]";
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

}
