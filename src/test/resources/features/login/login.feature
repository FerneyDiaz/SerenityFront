Feature: Login

  Scenario Outline: Login at backoffice with valid credentials
    Given Nimbus is an user list available
    And Nimbus is on the login page
    When He logs in with <rol> and valid credentials
    Then He should see the dashboard
    When He logs out
    Then He should see the login page
    Examples:
      |rol|
      |logistic|
      |operational|
      |service |
      |itSupport|
      |supervisor|
      |superAdmin|

    @test
    Scenario: Login failed at backoffice
      Given Nimbus is an non existing user
      When He is on the login page
      And He logs in with nonExisting and valid credentials
      Then He should see an error message for non existing user