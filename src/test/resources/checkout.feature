Feature: Checkout

  @positive-test
  Scenario Outline: checkout single item
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click login button
    And user is on homepage
    And user click on product with the name "<item>"
    And user is on detail product page "<item>"
    And user click add to cart button with id "<id button>"
    And user go to cart page
    And cart should contain product "<item>"
    When user click checkout
    And user fill shipping information
    And user click continue button
    And user on checkout overview page
    And total price is correct
    And click finish button
    Then checkout complete

    Examples:
      | item                      | id button                             |
      | Sauce Labs Backpack       | add-to-cart-sauce-labs-backpack       |
      | Sauce Labs Bolt T-Shirt   | add-to-cart-sauce-labs-bolt-t-shirt   |
      | Sauce Labs Fleece Jacket  | add-to-cart-sauce-labs-fleece-jacket  |

  @positive-test
  Scenario: checkout multiple items
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    And user click login button
    And user is on homepage
    And user click add to cart button with following id:
      | add-to-cart-sauce-labs-backpack       |
      | add-to-cart-sauce-labs-bolt-t-shirt   |
      | add-to-cart-sauce-labs-fleece-jacket  |
    And user go to cart page
    And cart should contain the following items name:
      | Sauce Labs Backpack       |
      | Sauce Labs Bolt T-Shirt   |
      | Sauce Labs Fleece Jacket  |
    When user click checkout
    And user fill shipping information
    And user click continue button
    And user on checkout overview page
    And total price is correct
    And click finish button
    Then checkout complete