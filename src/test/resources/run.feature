Feature: My feature description

  Scenario: Verify that GET request return status code 200
    Given I have server by url "https://reqres.in"
    When I send GET request on endpoint "/api/users/2" and parameters ""
    Then I get response status code 200

  Scenario: Verify that GET LIST USERS request returns status code 200
    Given I have server by url "https://reqres.in"
    When I send GET request on endpoint "/api/users?" and parameters "page=2"
    Then I get response status code 200
    Then I got total number of all users 12

  Scenario: Verify that GET SINGLE USER request returns status code 404 not found
    Given I have server by url "https://reqres.in"
    When I send GET request on endpoint "/api/users/23" and parameters ""
    Then I get response status code 404

  Scenario: Verify that GET LIST RESOURCE request returns list of users
    Given I have server by url "https://reqres.in"
    When I send GET request on endpoint "/api/unknown" and parameters ""
    Then I get response status code 200
    And I get id of first user = 1
    And I get name of this user as "fuchsia rose"

  Scenario Outline: Verify that GET LIST USERS request returns status code 200
    Given I have server by url "https://reqres.in"
    When I send GET request on endpoint "/api/users?" and parameters "page=2"
    Then I get response status code 200
    #And I get "<firstname>" and "<lastname>" of "<num>" user in list

    Examples:
    | num|firstname|lastname|
    |  1 |Michael |  Lawson |
    |  2 |Lindsay |  Ferguson |

  Scenario: Verify that CREATE with POST an user
    Given I have server by url "https://reqres.in"
    When I send POST request on endpoint "/api/users" and parameters "testername" and "manualQA"
    Then I get response status code 201
    And I get name of this user as "testername"

  Scenario: Verify that PUT update an existed user
    Given I have server by url "https://reqres.in"
    When I send PUT request on endpoint "/api/users/2" and parameters "morpheus" and "zion resident"
    Then I get response status code 200
    And I get updated timestamp not null
