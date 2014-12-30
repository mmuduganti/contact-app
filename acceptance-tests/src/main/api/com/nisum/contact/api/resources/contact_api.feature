# What is Feature
#
#This is the feature title
#This is the description of the feature, which can span multiple lines.
#You can even include empty lines, like this one:
#In fact, everything until the next Gherkin keyword is included in the description.

#Feature injection template
#In order to <meet some goal>
#As a <type of stakeholder>
#I want <a feature>
Feature: Contact Management service
  In order to manage my contacts
  As a user
  I want to add/edit/view my contacts


  Scenario: Create a contact
  # What is Scenario
  #To actually express the behavior we want, each feature contains several scenarios.
  #Each scenario is a single concrete example of how the system should
  #behave in a particular situation. If you add together the behavior defined by
  #all of the scenarios, that’s the expected behavior of the feature itself.

  #Each scenario must make sense and be able to be executed independently of
  #any other scenario.
    Given I have the following details:
      | fname | lname    | age | phoneNum     |
      | maria | testcase | 20  | 510-123-1234 |
    When I create contact
    Then the contact is created
    And I see the following values in response:
      | fname | lname    | age | phoneNum     |
      | maria | testcase | 20  | 510-123-1234 |