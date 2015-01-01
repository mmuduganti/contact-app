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
      | firstName | lastName | phoneNum     |
      | maria     | testcase | 510-123-1234 |
    #Data Tables
    #Sometimes steps in a scenario need to describe data that doesn’t easily fit on
    #a single line of Given, When, or Then. Gherkin allows us to place these details in
    #a table right underneath a step. Data tables give you a way to extend a Gherkin
    #step beyond a single line to include a larger piece of data.
    When I create contact
    Then the contact is created
    When I lookup contact with first name "maria"
    And I see contact created with following values:
      | firstName | lastName | phoneNum     |
      | maria     | testcase | 510-123-1234 |


  Scenario Outline: Create multiple contacts
  #Sometimes you have several scenarios that follow exactly the same pattern
  #of steps, just with different input values or expected outcomes.
  #It is followed by Examples or Scenarios element
    Given I have the following details:
      | firstName | lastName | phoneNum   |
      | <fname>   | <lname>  | <phoneNum> |
        #Data Tables
        #Sometimes steps in a scenario need to describe data that doesn’t easily fit on
        #a single line of Given, When, or Then. Gherkin allows us to place these details in
        #a table right underneath a step. Data tables give you a way to extend a Gherkin
        #step beyond a single line to include a larger piece of data.
    When I create contact
    Then the contact is created
    When I lookup contact with first name "<fname>"
    And I see contact created with following values:
      | firstName | lastName | phoneNum   |
      | <fname>   | <lname>  | <phoneNum> |

  Examples:
    | fname | lname    | phoneNum     |
    | janet | testcase | 510-123-1233 |
