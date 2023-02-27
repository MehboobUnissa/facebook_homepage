Feature: User should be able to click and access functionalities of Facebook Homepage.

  Background: User is logged into facebook website.
    Given user open facebook login page
    When user enters login credentials
    Then user is successfully logged in

  Scenario: User should be able to click icons in homepage
    Given user should navigate to homepage
    When user should click icons in homepage
    Then user should navigate to respective page

  Scenario: User should be able to click on stories and reels
      Given user should be able to click on story and reels
      When user is able to see stories and reels
      Then relevant story and reels should be displayed to user

  Scenario: User should be able to access status tab in homepage
        Given user is able to click on live,add photos and react
        When user is able to access live,add photos and react
        Then relevant box is displayed in homepage to user

    @smoke
  Scenario: User should be able to like and comment on posts
    Given post should be displayed on homepage
    When user is able to click on Like and Comment button
    Then post should be Liked and Comment should be displayed

  Scenario: User should be able to create group
    Given user is able to click on create group
    When user is able to add two or more friends
    Then group is created with selected friends

  Scenario Outline: Search
    Given user is on Homepage
    When user type the "<text>"
    Then relevant "<results>" should be displayed
    Examples:
      | text            | results |
      | Mehboob Unissa  | true    |
      | Laughter colors | true    |




