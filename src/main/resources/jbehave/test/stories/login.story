Narrative:
 En tant que un client
 il peut se connecter � son compte  
 afin de continuer la procedure d'achat

Sc�nario : authentification avec des identit�s valides puis aves des identit�s invalides

Given le client veut se connecter
When il saisit son adresse email alex-1@gmail.com et son mot de passe alex1250
Then son panier sera affich�

Given le client veut se connecter
When il saisit son adresse email alex-1@gmail.com et son mot de passe alex12
Then un message d'erreur mot de passe invalide! sera affich�