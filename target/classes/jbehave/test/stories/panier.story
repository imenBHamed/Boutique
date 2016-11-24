Narrative:
 En tant que un utilisateur 
 il peut choisir un produit 
 afin de l'ajouter dans son panier d'achat
			
Scénario: Ajouter un produit au panier
			
Given page liste Produit
When je clique sur //a[@onclick="window.location.href='detailProduit.html?id=1'"] et je saisi 1 comme quantite et je clique sur ajouter_au_panier
Then le total css=li:nth-child(3) de panier sera TOTAL : 114.5 $