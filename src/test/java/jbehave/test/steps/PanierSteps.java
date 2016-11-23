package jbehave.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.SeleniumSteps;

import com.thoughtworks.selenium.Selenium;


public class PanierSteps extends SeleniumSteps{
 
 public PanierSteps(Selenium selenium) {
super(selenium);
}

 @Given("page liste Produit")
 public void givenPageListeProduit() {
	 selenium.open("/controller");
	
 }

 @When("l'usager choisi produit1")
 public void whenLusagerChoisiProduit1() {
   // PENDING
 }

 @Then(" total 100$\r\nand Panier contient Produit1")
 public void thenTotal100AndPanierContientProduit1() {
   // PENDING
 }
/*
	@Given("page liste produit")
	public void givenPageList() {
		selenium.open("listProduit.html");
	}

	@When("je choisi le produit $produit")
	public void whenJeChoisiProduit(final int a) {
		// selenium.click("//a/u[contains(text(),'Detail Produit')]");

	}*/
}
