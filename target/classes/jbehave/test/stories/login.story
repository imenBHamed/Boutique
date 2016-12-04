Narrative:
 En tant que un client
 il peut se connecter à son compte  
 afin de continuer la procedure d'achat

Scénario : authentification avec des identités valides puis aves des identités invalides

Given le client veut se connecter
When il saisit son adresse email alex-1@gmail.com et son mot de passe alex1250
Then son panier sera affiché

Given le client veut se connecter
When il saisit son adresse email alex-1@gmail.com et son mot de passe alex12
Then un message d'erreur mot de passe invalide! sera affiché