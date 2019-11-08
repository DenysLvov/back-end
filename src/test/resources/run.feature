Feature: My feature description

Scenario: Verify that GET request return status code 200
   Given I have server by url "https://reqres.in"
   When I send GET request on endpoint "/api/users/2" and parameters ""
   Then I get response status code 200
