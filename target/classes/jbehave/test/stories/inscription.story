Narrative:
 En tant que un utilisateur 
 il peut s'inscrire 
 afin d'avoir un compte client
			
Scénario: inscription
				
Given l'utilisateur veut s'inscrire 
When il saisi son nom alex , son prenom cardinal , son numero de tel 51463325 , sa date de naissance 11/03/2016 , son adresse email alex-1@gmail.com et son mot de passe alex1250
Then le compte de client a été crée avec succès

When il saisi son nom imen , son prenom imen , son numero de tel 20120333 , sa date de naissance 11/11/2016 , son adresse email imen@gmail.com et son mot de passe imen
Then le compte est déjà existe