package jbehave.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.SeleniumSteps;

import com.thoughtworks.selenium.Selenium;

public class incriptionSteps extends SeleniumSteps{
	public incriptionSteps(Selenium selenium) {
		super(selenium);
	}
	
	@Given("l'utilisateur veut s'inscrire")
	public void givenLutilisateurVeutSinscrire() {
		selenium.open("/controller/login.html");
	}

	@When("il saisi son nom $nom , son prenom $prenom , son numero de tel $tel , sa date de naissance $dateNaiss , son adresse email $email et son mot de passe $password")
	public void whenIlSaisiInformations(String nom, String prenom, String tel, String dateNaiss, String email, String password) {
	  selenium.type("nomClient", nom);
	  selenium.type("prenomClient", prenom);
	  selenium.type("email", email);
	  selenium.type("password", password);
	  selenium.type("tel", tel);
	  selenium.type("dateNaissance", dateNaiss);
	}

	@Then("le client s'est inscrit")
	public void thenLeClientSestInscrit() {
	}
	
	



}
