#Author: Vishnu MJ
#Keywords Summary : Create Note feature

Feature: Create Note test cases


@initBrowser @closeBrowser
Scenario Outline: Verify the Create Note functionality
Given login to the application
Then user clicks on create note
Then add title "<title>" and content "<content>"
Then logout from the application
Examples:
|title          |content                                                |
|Brain Injury   |Prevention and Treatment of Chronic Brain Injury       |


@initBrowser @closeBrowser
Scenario Outline: Verify the view note
Given login to the application
Then verify title "<title>" in the dashboard
Then click on the existing note
Then logout from the application
Examples:
|title          |
|Brain Injury   |
