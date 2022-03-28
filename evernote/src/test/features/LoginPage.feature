#Author: Vishnu MJ
#Keywords Summary : Login Page feature

Feature: Login Page test cases


@initBrowser @closeBrowser
Scenario: Verify the Login of Evernote
Given url is loaded
Then login with valid credentails
Then verify login success

@initBrowser @closeBrowser
Scenario: Verify Login with incorrect username
Given url is loaded
Then login with wrong username
Then verify login failure
