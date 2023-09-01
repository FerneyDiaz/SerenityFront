Feature: Create vehicle at backoffice for an user successfully
Fetch vehicles that has been created

  Scenario: Create vehicle to legal entity PJ
    Given Nimbus is an create vehicle to pj
    And Nimbus is on the login page
    When He logs in with superUser and valid credentials
    Then He should see the dashboard
    And He is on the vehicles component
    Then He should see the vehicle component
    When He create a vehicle
    Then He should see an successful creation message
    And He delete vehicle created
    When He logs out
    Then He should see the login page

  Scenario: Create vehicle to natural person
    Given Nimbus is an create vehicle to pn
    And Nimbus is on the login page
    When He logs in with superUser and valid credentials
    Then He should see the dashboard
    And He is on the vehicles component
    Then He should see the vehicle component
    When He create a vehicle
    Then He should see an successful creation message
    And He delete vehicle created
    When He logs out
    Then He should see the login page