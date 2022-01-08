
Feature: Test Techique Automatisation
  @demoga
  Scenario: Achat de produit
    Given Naviguer  se rend sur l'url "http://shop.demoqa.com/"
    And Choisir n’importe quel article et le sélectionner
    And Choisir une option couleur (Color) et une option taille (Size)
    And Cliquer sur le bouton ADD TO CART
    And Un message de succès doit s’afficher : “article_name” has been added to your cart
    And Cliquer ensuite sur le bouton « View cart »
    And L’article doit se rajouter dans le panier, et le total de prix doit s’afficher dans le panier en haut.
    And Cliquer sur le bouton « Proceed to checkout »
    And Un formulaire de payement doit s’afficher
    And Remplir tous les champs obligatoires du formulaire à savoir le nom, le prénom, le pays, l’adresse, le numéro de téléphone, l’adresse mail, et cocher la case « I HAVE READ AND AGREE TO THE WEBSITE TERMS AND CONDITIONS »
    Then Cliquer ensuite sur le bouton «PLACE ORDER »
    And Un message de succès doit s’afficher avec les détails de la commande d’achat.



