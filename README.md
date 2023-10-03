# Weather_Shopper
Dans ce mini projet vous devez utiliser Weather Shopper, une simple application Web imitant le commerce électronique.
L'application dispose d'à peu près suffisamment d'éléments de logique métier et d'interface utilisateur pour couvrir de nombreux domaines.
Voici quelques aspects à respecter :
• Vous devez utiliser Java comme langage de programmation et Selenium comme framework de test.
• solution doit avoir une structure modulaire
Configuration => classe avec les fonctions qui gère l’ouverture de l’application et le close de driver
 Pages => les classes page obejct model
tests_suite => contient une classe avec les tests demandés
 utils => contient une classe commun
pour aller plus loin (vous pouvez voir comment utiliser le fichier .properties et Log4j)
• Votre solution doit être indépendante d'un système d'exploitation particulier.
• Votre solution doit prendre en charge deux navigateurs différents.
Cas test 1 : Achat d’un Moisturizers
Je me connecte au site https://weathershopper.pythonanywhere.com/
Je check si je me suis bien redirigé vers la page Current temperature
Je clique sur le bouton Buy moisturizers
Je check si je me suis redirigé vers la page Moisturizers
Je check que chaque produit est affiché avec son titre et son prix
J’ajoute le 1er produit à mon panier
Je check que le panier contient un item
Je clique sur carte
Je check que je me suis redirigé vers la page checkout
Je check si le produit ajouté correspond bien à mon produit (titre , prix , total)
Je clique sur le bouton Pay with card
Je check si la popup Stripe.com s’affiche 
Je saisis les informations nécessaires pour compléter l’achat (email, card number , date , cvc, zip code)
Je check le total affiché sur le pop-up
Je clique sur le bouton pay iner
Je check si je me suis bien redirigé vers la page confirmation
Je check si le message Your payment was successful. You should receive a follow-up call from our sales team est bien affiché













Cas test 2 : Achat d’un Sunscreens
Je me connecte au site https://weathershopper.pythonanywhere.com/
Je check si je me suis bien redirigé vers la page Current temperature
Je clique sur le bouton Buy sunscreens
Je check si je suis redirigé vers la page Sunscreens
Je check que chaque produit est affiché avec son titre et son prix
J’ajoute le 1er produit à mon panier
Je check que le panier contient un item
Je clique sur carte
Je check que je me suis redirigé vers la page checkout
Je check si le produit ajouté correspond bien à mon produit (titre, prix , total)
Je clique sur le bouton Pay with card
Je check si la popup Stripe.com s’affiche 
Je saisis les infos nécessaires pour compléter l’achat (email, card number , date , cvc, zip code)
Je clique sur le bouton pay iner
Je check si je me suis bien redirigé vers la page confirmation
Je check si le message Your payment was successful. You should receive a follow-up call from our sales team est bien affiché













Cas test 3 : achat d’un sunscreens
Je me connecte au site https://weathershopper.pythonanywhere.com/
Je check si je me suis bien redirigé vers la page Current temperature
Je clique sur le bouton Buy sunscreens
Je check si je me suis redirigé vers la page Sunscreens
J’ajoute deux Sunscreens à mon panier. Tout d’abord, je sélectionne Sunscreens la moins chère, à savoir SPF-50. Pour mon deuxième Sunscreens, je sélectionne Sunscreens la moins chère qui est SPF-30. 
Je check que le panier contient deux items
Je clique sur carte
Je check que je me suis redirigé vers la page checkout
Je check si les produits ajoutés correspondent bien à mes produits (titre, prix , total)
Je clique sur le bouton Pay with card
Je check si la popup Stripe.com s’affiche 
Je saisis les infos nécessaires pour compléter l’achat (email, card number , date , cvc, zip code)
Je clique sur le bouton pay iner
Je check si je me suis bien redirigé vers la page confirmation
Je check si le message Your payment was successful. You should receive a follow-up call from our sales team est bien affiché












Cas test 4 : achat d’un produit en fonction de la température
Je me connecte au site https://weathershopper.pythonanywhere.com/
Je check la température 
Si la température supérieure à 34 degrés j’achète Sunscreens 
Sinon si la température est inférieure à 19 degrés j’achète moisturizers  

S’il s’agit d’un Sunscreens
J’ajoute deux Sunscreens à mon panier. Tout d’abord, je sélectionne Sunscreens la moins chère, à savoir SPF-50. Pour mon deuxième Sunscreens, je sélectionne Sunscreens la moins chère qui est SPF-30. 
S’il s’agit d’un Moisturizers
J’ajoutez deux moisturizers à mon panier. Tout d’abord, je sélectionne moisturizers la moins chère, à savoir SPF-50. Pour mon deuxième crème solaire, je sélectionne moisturizers la moins chère qui est SPF-30. 
Je check que le panier contient deux items
Je clique sur carte
Je check que je me suis redirigé vers la page checkout
Je check si les produits ajoutés correspondent bien à mes produit (titre, prix , total)
Je clique sur le bouton Pay with card
Je check si la popup Stripe.com s’affiche 
Je saisis les infos nécessaires pour compléter l’achat (email, card number , date , cvc, zip code)
Je clique sur le bouton pay iner
je check si je me suis bien redirigé vers la page confirmation
Je check si le message « Your payment was successful. You should receive a follow-up call from our sales team.  est bien affiché

