Narrative:
 En tant que un utilisateur 
 il peut choisir un produit 
 afin de l'ajouter dans son panier d'achat
			
Scénario: Ajouter un produit au panier
			
Given page liste Produit
When l'usager choisi produit1
Then  total 100$
and Panier contient Produit1


