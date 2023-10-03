Feature: Effectuer un achat sur le site

  Scenario Outline: Acheter un produit avec différentes informations de paiement
    Given Go To Home Page
    And Je clique sur le bouton "Buy moisturizers"
    And Je suis redirigé vers la page "Moisturizers"
    And Chaque produit est affiché avec son "titre" et son "prix"
    And J’ajoute le 1er produit à mon panier
    And Je clique sur "carte"
    And Je suis redirigé vers la page "checkout"
    And Je vérifie si le produit ajouté a le bon "titre", "prix", et "total"
    And Je clique sur le bouton "Pay with card"
    And Une popup "Stripe.com" s'affiche
    And Je saisis les informations nécessaires pour compléter l’achat
      | email           | card number       | date  | cvc | zip code |
      | <email>         | <card_number>     | <date>| <cvc>| <zip_code>|
    And Je vérifie le total affiché sur le pop-up
    And Je clique sur le bouton "pay"
    And Je suis redirigé vers la page "confirmation"
    Then Je devrais voir le message "Your payment was successful. You should receive a follow-up call from our sales team"

    Examples:
      | email            | card_number         | date  | cvc | zip_code |
      | example@email.com| 4242 4242 4242 4242 | 12/24 | 123 | 12345    |
      # Ajoutez d'autres jeux de données ici si nécessaire

    # Continuez avec d'autres scénarios ou étapes si nécessaire
