package jbehave.test.steps;

import javax.validation.constraints.AssertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.SeleniumSteps;

import com.thoughtworks.selenium.Selenium;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PanierSteps extends SeleniumSteps{
 
 public PanierSteps(Selenium selenium) {
super(selenium);
}

 @Given("page liste Produit")
 public void givenPageListeProduit(){
	 selenium.open("/controller/listProduit.html");
 }

 @When("je clique sur $xpath et je saisi $qte comme quantite et je clique sur $bouton")
 public void whenJeCliqueSur(String xpath, String qte, String bouton){
  selenium.click("xpath=" + xpath);
  
  selenium.waitForPageToLoad("30000");
  selenium.type("qte", qte);
  selenium.click(bouton);
  selenium.waitForPageToLoad("30000");
 }

 @Then("le total $colonne de panier sera $prix")
 public void thenLeTotalDePanierSera(String colonne, String prix) {
	 assertThat(selenium.getText(colonne), equalTo(prix));
 }

}
