Feature: Send Slack Message

  Scenario: Sending a new message to Harsh via Slack using Google Sign-In
    Given I am on slack webpage
    When I click on the "Sign In" button
    Then I should be taken to the login Page
    When I click on "sign in manually instead"
    Then I should be taken to the Workspace login page
    And I enter my workspace name and submit
    And I click on "sign in with a password instead"
    And I enter my email and password and submit
    Then I should be taken to my workspace
    And I select recipient
    And I enter message in the input and click send
    Then Message should be sent to recipient
