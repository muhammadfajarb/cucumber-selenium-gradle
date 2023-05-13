Feature: Cart

  @positive-test
  Scenario: Adding items to the cart from homepage
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click login button
    And user is on homepage
    When user click add to cart button with following id:
      | add-to-cart-sauce-labs-backpack       |
      | add-to-cart-sauce-labs-bolt-t-shirt   |
      | add-to-cart-sauce-labs-fleece-jacket  |
    And user go to cart page
    Then cart should contain the following items name:
      | Sauce Labs Backpack       |
      | Sauce Labs Bolt T-Shirt   |
      | Sauce Labs Fleece Jacket  |

  @positive-test
  Scenario Outline: Adding items to the cart from detail product page
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click login button
    And user is on homepage
    And user click on product with the name "<item>"
    And user is on detail product page "<item>"
    When user click add to cart button with id "<id button>"
    And user go to cart page
    Then cart should contain product "<item>"

    Examples:
      | item                      | id button                             |
      | Sauce Labs Backpack       | add-to-cart-sauce-labs-backpack       |
      | Sauce Labs Bolt T-Shirt   | add-to-cart-sauce-labs-bolt-t-shirt   |
      | Sauce Labs Fleece Jacket  | add-to-cart-sauce-labs-fleece-jacket  |
