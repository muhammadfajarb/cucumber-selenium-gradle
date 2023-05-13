Feature: Login

  @positive-test
  Scenario: Login using valid email and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

  @negative-test
  Scenario: Login using invalid email and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "invalid"
    When user click login button
    Then user see error message "Epic sadface: Username and password do not match any user in this service"

  @negative-test
  Scenario: Login using locked out user
    Given user is on login page
    And user input username with "locked_out_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user see error message "Epic sadface: Sorry, this user has been locked out."

  @boundary-test
  Scenario: Username can not be empty, at least need 1 character
    Given user is on login page
    And user input username with ""
    And user input password with ""
    When user click login button
    Then user see error message "Epic sadface: Username is required"

  @boundary-test
  Scenario: Password can not be empty, at least need 1 character
    Given user is on login page
    And user input username with "standard_user"
    And user input password with ""
    When user click login button
    Then user see error message "Epic sadface: Password is required"