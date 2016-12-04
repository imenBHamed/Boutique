Narrative:
 En tant que un utilisateur 
 il peut choisir un produit 
 afin de l'ajouter dans son panier d'achat
			
Scénario: Ajouter un produit au panier
	
Given panier est vide			
Given liste de produits contient produit 1 avec prix 1050.21 et produit 2 avec prix 100.12
When je selectionne produit 1 et je saisi 1 comme quantite
Then apres le calcul de TVQ et TPS le totalpanier sera 1202.49

Given liste de produits contient produit 1 avec prix 1050.21 et produit 2 avec prix 100.12
When je selectionne produit 2 et je saisi 2 comme quantite
Then apres le calcul de TVQ et TPS le totalpanier sera 1431.76


When je supprime le produit 1 du mon panier
Then apres le calcul de TVQ et TPS le totalpanier sera 229.27