#Feature: Validate response from GET /public/v2/users
#
#  Scenario: User sends a GET request and validates the response
#    Given the user sets the base url "https://gorest.co.in/public/v2/users"
#    When the user sends a GET request
#    Then the response status code should be 200
